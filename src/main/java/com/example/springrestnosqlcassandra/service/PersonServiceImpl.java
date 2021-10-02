package com.example.springrestnosqlcassandra.service;

import com.example.springrestnosqlcassandra.dao.PersonRepoDao;
import com.example.springrestnosqlcassandra.dto.PersonDto;
import com.example.springrestnosqlcassandra.dto.PersonPrimDto;
import com.example.springrestnosqlcassandra.entity.Person;
import com.example.springrestnosqlcassandra.entity.PersonPrim;
import com.example.springrestnosqlcassandra.utils.Mapper;
import lombok.Synchronized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepoDao personRepoDao;
    private final Mapper mapper;

    @Autowired
    public PersonServiceImpl(PersonRepoDao personRepoDao, Mapper mapper) {
        this.personRepoDao = personRepoDao;
        this.mapper = mapper;
    }


    @Override
    public PersonDto addPerson(PersonDto personDto) {
        Person person = mapper.convert(personDto, Person.class);
        return mapper.convert(personRepoDao.save(person), PersonDto.class);
    }

    @Override
    public List<PersonDto> getByName(String name) {
        return mapper.convertToList(personRepoDao.findByKeyFirstName(name), PersonDto.class);
    }

    @Override
    public List<PersonDto> getByNameAndLastName(String name, String lastName) {
        return mapper.convertToList(personRepoDao.findByKeyFirstNameAndKeyLastName(name, lastName), PersonDto.class);
    }

    @Override
    @Synchronized
    public boolean deletePerson(PersonPrimDto id) {
        PersonPrim personPrim = mapper.convert(id, PersonPrim.class);
        if (personRepoDao.findById(personPrim).isPresent()) {
            personRepoDao.deleteById(personPrim);
            return true;
        }
        return false;
    }
}
