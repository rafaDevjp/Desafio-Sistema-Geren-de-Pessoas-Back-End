package one.innovation.digital.personApi.mapper;


import one.innovation.digital.personApi.DTO.request.PersonDTO;
import one.innovation.digital.personApi.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapperPerson {

    MapperPerson INSTANCE = Mappers.getMapper(MapperPerson.class);

   @Mapping (target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);

}
