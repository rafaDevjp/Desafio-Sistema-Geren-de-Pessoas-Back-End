package one.innovation.digital.personApi.service;


import one.innovation.digital.personApi.DTO.MessageResponseDTO;
import one.innovation.digital.personApi.entity.Person;
import one.innovation.digital.personApi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private static PersonRepository personRepository;

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
}
