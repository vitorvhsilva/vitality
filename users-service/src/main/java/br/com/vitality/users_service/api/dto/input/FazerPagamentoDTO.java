package br.com.vitality.users_service.api.dto.input;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FazerPagamentoDTO {
    private Long idUsuario;
    private BigDecimal valor;
}
