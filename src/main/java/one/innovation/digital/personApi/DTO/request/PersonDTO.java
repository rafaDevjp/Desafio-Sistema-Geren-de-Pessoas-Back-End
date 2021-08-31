package one.innovation.digital.personApi.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Long id;

    @NotEmpty
    @Size(max = 20)
    private String nome;

    @NotEmpty
    @Size(max = 50 )
    private String sobrenome;

    @NotEmpty
    @CPF
    private String cpf;

    private String birthDate;

    @Valid
    @NotEmpty
    private List<PhoneDTO> phones;

}
