package br.com.vitality.users_service.api.dto.input;

import br.com.vitality.users_service.domain.utils.enums.Assinatura;
import lombok.Data;

@Data
public class PagamentoOutputDTO {
    private Long idUsuario;
    private Assinatura assinatura;
}
