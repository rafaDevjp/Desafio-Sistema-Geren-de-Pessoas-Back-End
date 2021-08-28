package one.innovation.digital.personApi.DTO.request;

import one.innovation.digital.personApi.enums.PhoneType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class PhoneDTO {

    private long id;

    @Enumerated(EnumType.STRING)
    private PhoneType type;


    @NotEmpty
    @Size(min = 13, max = 15)
    private String number ;
}
