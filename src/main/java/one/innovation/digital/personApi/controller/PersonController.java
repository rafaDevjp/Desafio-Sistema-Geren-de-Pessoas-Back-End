package one.innovation.digital.personApi.controller;


import one.innovation.digital.personApi.DTO.MessageResponseDTO;
import one.innovation.digital.personApi.DTO.request.PersonDTO;
import one.innovation.digital.personApi.entity.Person;

import one.innovation.digital.personApi.exceptions.PersonNotFoundException;
import one.innovation.digital.personApi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody Person  person) {

        return PersonService.createPerson(person);
    }


    @GetMapping
     public List<PersonDTO> listAll() {
        return personService.listAll();
    }
    @GetMapping("{id}")
     public PersonDTO findById(@PathVariable  Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }
}
