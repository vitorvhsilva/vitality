package br.com.vitality.payments_service.domain.service.strategy

import br.com.vitality.payments_service.domain.model.Pagamento

interface ValidarPagamentoStrategy {
    fun validar(pagamento: Pagamento)
}