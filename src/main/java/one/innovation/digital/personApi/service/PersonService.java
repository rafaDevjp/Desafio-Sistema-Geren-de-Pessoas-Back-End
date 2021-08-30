package one.innovation.digital.personApi.service;


import one.innovation.digital.personApi.DTO.MessageResponseDTO;
import one.innovation.digital.personApi.DTO.request.PersonDTO;
import one.innovation.digital.personApi.entity.Person;
import one.innovation.digital.personApi.exceptions.PersonNotFoundException;
import one.innovation.digital.personApi.mapper.MapperPerson;
import one.innovation.digital.personApi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private static PersonRepository personRepository;

     private final MapperPerson  mapperPerson = MapperPerson.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {

        this.personRepository = personRepository;
    }

    public static MessageResponseDTO createPerson(Person person) {
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created Person ID" + savedPerson.getId())
                .build();
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(mapperPerson::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person personId = verifyIfExists(id);
        return mapperPerson.toDTO(personId);
    }

    public void delete(Long id) throws PersonNotFoundException{
     verifyIfExists(id);
        personRepository.deleteById(id);
    }

   private Person verifyIfExists(Long id ) throws PersonNotFoundException{
       return personRepository.findById(id)
               .orElseThrow(() -> new PersonNotFoundException(id));
    }


}
