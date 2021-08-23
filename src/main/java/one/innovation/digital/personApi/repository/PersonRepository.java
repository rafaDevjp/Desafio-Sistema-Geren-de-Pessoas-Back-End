package one.innovation.digital.personApi.repository;

import one.innovation.digital.personApi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {


}
