package com.ds.swagger.controllers.person;

import com.ds.swagger.dto.PersonDTO;
import com.ds.swagger.entities.Person;
import com.ds.swagger.exceptions.PersonNotFoundException;
import com.ds.swagger.exceptions.WrongPrimaryKeysException;
import com.ds.swagger.mapper.IPersonMapper;
import com.ds.swagger.service.PersonService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@Api(value = "/test/person")
@RequestMapping(value = "/person")
public class PersonController {
    private static final Logger LOGGER = Logger.getLogger( PersonController.class.getName() );
    private final IPersonMapper mapper;
    private final PersonService service;

    @Value("${com.ds.thisAnnotation}")
    private String helloDavid;

    @Autowired
    public PersonController(IPersonMapper mapper, PersonService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO post(@RequestBody PersonDTO personDTO){
        LOGGER.log(Level.INFO, "DTO : " +personDTO);

        Person p = mapper.personDTOToPerson(personDTO);
        LOGGER.log(Level.INFO, "ENTITY: " + p);

        return mapper.personToPersonDTO(service.save(p));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO put(@PathVariable Long id, @RequestBody PersonDTO person) throws WrongPrimaryKeysException, PersonNotFoundException {
        Person p = service.update(id, mapper.personDTOToPerson(person));

        return mapper.personToPersonDTO(p);

    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonDTO> getAll(){

        return mapper.personsToPersonsDTO(service.findAll());
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id){
        service.delete(id);
    }

    @GetMapping(value = "/custom/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person customGet(@PathVariable("name") String name){
        return service.findByNameV2(name);
    }

}
