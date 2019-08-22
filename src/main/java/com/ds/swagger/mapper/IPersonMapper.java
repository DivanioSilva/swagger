package com.ds.swagger.mapper;

import com.ds.swagger.dto.PersonDTO;
import com.ds.swagger.entities.Person;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IPersonMapper {
    PersonDTO personToPersonDTO(Person person);

    Person personDTOToPerson(PersonDTO personDTO);

    List<PersonDTO> personsToPersonsDTO(List<Person> persons);
}
