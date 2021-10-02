package com.example.springrestnosqlcassandra.controller;

import com.example.springrestnosqlcassandra.dto.PersonDto;
import com.example.springrestnosqlcassandra.dto.PersonPrimDto;
import com.example.springrestnosqlcassandra.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
@RequestMapping(
        produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class PersonRestController {
    final private PersonServiceImpl personService;

    @Autowired
    public PersonRestController(PersonServiceImpl personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/getpersonbyfirstname")
    public ResponseEntity<List<PersonDto>> getPersonByFirstName(@RequestParam(required = false) String name) {
        return new ResponseEntity<>(personService.getByName(name), HttpStatus.OK);
    }

    @GetMapping(value = "/getpersonbyfirstnameandlastname")
    public ResponseEntity<List<PersonDto>> getPersonByFirstNameAndLastName(@RequestParam(required = false)
                                                                           @Size(min = 2, max = 15, message = "{name.size.invalid}")
                                                                           @NotEmpty(message = "{name.empty}")
                                                                           @Pattern(regexp = "^[A-Za-z]*$", message = "{invalid.name}") String name,
                                                                           @RequestParam(required = false)
                                                                           @Size(min = 2, max = 15, message = "{lastname.size.invalid}")
                                                                           @NotEmpty(message = "{lastname.empty}")
                                                                           @Pattern(regexp = "^[A-Za-z]*$", message = "{invalid.lastname}") String lastname) {
        return new ResponseEntity<>(personService.getByNameAndLastName(name, lastname), HttpStatus.OK);

    }

    @PostMapping("/person")
    public ResponseEntity<PersonDto> create(@Valid @RequestBody PersonDto personDto) {
        return new ResponseEntity<>(personService.addPerson(personDto), HttpStatus.OK);
    }

    @DeleteMapping("/persondelete")
    public ResponseEntity<String> deletePerson(@RequestBody PersonPrimDto personPrimDto) {
        return personService.deletePerson(personPrimDto) ? new ResponseEntity<>("User with ID :" + personPrimDto.getId() + " deleted successfully", HttpStatus.OK) :
                new ResponseEntity<>("could not delete person", HttpStatus.NOT_FOUND);
    }
}
