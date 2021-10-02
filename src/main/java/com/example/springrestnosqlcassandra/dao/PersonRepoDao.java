package com.example.springrestnosqlcassandra.dao;

import com.example.springrestnosqlcassandra.entity.Person;
import com.example.springrestnosqlcassandra.entity.PersonPrim;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepoDao extends CassandraRepository<Person, PersonPrim> {
    List<Person> findByKeyFirstNameAndKeyLastName(String firstName, String lastName);

    List<Person> findByKeyFirstName(String firstName);
}
