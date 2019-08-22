package com.ds.swagger.service;

import com.ds.swagger.entities.Person;
import com.ds.swagger.exceptions.PersonNotFoundException;
import com.ds.swagger.exceptions.ValidationException;
import com.ds.swagger.exceptions.WrongPrimaryKeysException;

import java.util.List;

public interface PersonService {
    Person save(Person person) throws ValidationException;

    Person update(Long id, Person person) throws PersonNotFoundException, WrongPrimaryKeysException, ValidationException;

    Person findById(Long id) throws PersonNotFoundException;

    List<Person> findAll();

    Person findByName(String personName) throws PersonNotFoundException, ValidationException;

    void delete(Person person);

    void delete(Long id);

    Person findByNameV2(String personName) throws ValidationException;
}
