package dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;


@AllArgsConstructor
@Getter
public class UserRequest {

    @NotBlank()
    @Length(min = 3, max = 35)
    private String nome;

    private String senha;

    private String cpf;


}
