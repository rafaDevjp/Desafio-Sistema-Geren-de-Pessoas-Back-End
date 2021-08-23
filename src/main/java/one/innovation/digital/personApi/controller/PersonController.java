package one.innovation.digital.personApi.controller;


import one.innovation.digital.personApi.DTO.MessageResponseDTO;
import one.innovation.digital.personApi.entity.Person;

import one.innovation.digital.personApi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private PersonService apiService;

    @Autowired
    public PersonController(PersonService apiService){
        this.apiService = apiService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody Person  person) {
        return PersonService.createPerson(person);

    }
}
