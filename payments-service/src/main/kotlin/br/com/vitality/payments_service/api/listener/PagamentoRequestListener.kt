package br.com.vitality.payments_service.api.listener

import br.com.vitality.payments_service.api.dto.input.PagamentoInputDTO
import br.com.vitality.payments_service.domain.service.PagamentoService
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class PagamentoRequestListener(private val pagamentoService: PagamentoService) {

    @RabbitListener(queues = ["payment.request.queue"])
    fun persistirPagamento(@Payload dto: PagamentoInputDTO) {
        pagamentoService.persistirPagamento(dto)
    }
}