package br.com.vitality.users_service.api.dto.output;

import br.com.vitality.users_service.domain.utils.enums.Genero;
import lombok.Data;

@Data
public class UsuarioOutputDTO {
    private String nome;
    private String email;
    private String senha;
    private Genero genero;
    private Double altura;
    private Double peso;
}
