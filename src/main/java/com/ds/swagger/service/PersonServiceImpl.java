package com.ds.swagger.service;

import com.ds.swagger.entities.Person;
import com.ds.swagger.exceptions.PersonNotFoundException;
import com.ds.swagger.exceptions.ValidationException;
import com.ds.swagger.exceptions.WrongPrimaryKeysException;
import com.ds.swagger.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class PersonServiceImpl implements PersonService{
    private final PersonRepository personRepository;

    private static final Logger LOGGER = Logger.getLogger( PersonRepository.class.getName() );

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person save(Person person) throws ValidationException {
        proceedValidations(person);
        return personRepository.save(person);
    }

    @Override
    public Person update(Long id, Person person) throws PersonNotFoundException, WrongPrimaryKeysException, ValidationException {
        Optional<Person> optionalPerson = Optional.ofNullable(personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException()));

        if(!Objects.equals(id, person.getId())){
           throw  new WrongPrimaryKeysException();
        }

        proceedValidations(optionalPerson.get());

        Person personToUpdate = optionalPerson.get();
        personToUpdate.setAge(person.getAge());
        personToUpdate.setCity(person.getCity());
        personToUpdate.setName(person.getName());

        return personRepository.save(personToUpdate);
    }

    @Override
    public Person findById(Long id) throws PersonNotFoundException {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException());
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person findByName(String personName) throws PersonNotFoundException, ValidationException {
        Person p = new Person();
        p.setName(personName);
        proceedValidations(p);
        return personRepository.findByName(personName).orElseThrow(() -> new PersonNotFoundException());
    }

    @Override
    public void delete(Person person) {
        personRepository.delete(person);
    }

    @Override
    public void delete(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public Person findByNameV2(String personName) throws ValidationException {
        Person p = new Person();
        p.setName(personName);
        proceedValidations(p);
        return personRepository.test(personName).get();
    }

    private void proceedValidations(Person personToBeValidate) throws ValidationException {
        ValidatorFactory validator = Validation.buildDefaultValidatorFactory();
        Set<ConstraintViolation<Person>> validationErrors = validator.getValidator().validate(personToBeValidate);
        if(!validationErrors.isEmpty()) //If there are some errors then print those
        {
            for(ConstraintViolation<Person> invalidObj : validationErrors){

                System.out.println(invalidObj.getMessage());
                LOGGER.log( Level.SEVERE, "Validation error:" +invalidObj.getMessage()+" "+personToBeValidate.toString()+"" );
                throw new ValidationException(invalidObj.getMessage());
            }
        }
    }
}
