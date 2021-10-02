package com.example.springrestnosqlcassandra.service;

import com.example.springrestnosqlcassandra.dto.PersonDto;
import com.example.springrestnosqlcassandra.dto.PersonPrimDto;

import java.util.List;

public interface PersonService {
    PersonDto addPerson(PersonDto personDto);

    List<PersonDto> getByName(String name);

    List<PersonDto> getByNameAndLastName(String name, String lastName);

    boolean deletePerson(PersonPrimDto id);
}
