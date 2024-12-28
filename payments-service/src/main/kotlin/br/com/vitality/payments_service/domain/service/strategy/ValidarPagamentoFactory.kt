package br.com.vitality.payments_service.domain.service.strategy

import org.springframework.stereotype.Component

@Component
class ValidarPagamentoFactory(private val estrategias: List<ValidarPagamentoStrategy>) {
    fun getEstrategias(): List<ValidarPagamentoStrategy> = estrategias
}