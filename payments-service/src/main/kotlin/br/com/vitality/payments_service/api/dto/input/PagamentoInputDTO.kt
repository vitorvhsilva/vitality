package br.com.vitality.payments_service.api.dto.input

import java.math.BigDecimal

data class PagamentoInputDTO(
    val idUsuario: Long,
    val valor: BigDecimal,
)
