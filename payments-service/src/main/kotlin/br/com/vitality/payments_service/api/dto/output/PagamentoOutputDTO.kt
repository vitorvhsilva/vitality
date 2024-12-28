package br.com.vitality.payments_service.api.dto.output

import br.com.vitality.payments_service.domain.utils.enums.Assinatura

data class PagamentoOutputDTO(
    val idUsuario: Long,
    var assinatura: Assinatura,
)
