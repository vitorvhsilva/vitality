package br.com.vitality.users_service.api.dto.input;

import br.com.vitality.users_service.domain.utils.enums.Genero;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CadastroUsuarioDTO {
    @NotBlank @Size(min = 3)
    private String nome;
    @Email
    private String email;
    @NotBlank @Size(min = 8)
    private String senha;
    @Enumerated(value = EnumType.STRING)
    private Genero genero;
    @NotNull @Positive
    private Double altura;
    @NotNull @Positive
    private Double peso;
}

