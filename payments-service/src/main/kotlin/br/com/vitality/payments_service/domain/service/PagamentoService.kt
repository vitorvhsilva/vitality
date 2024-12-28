package br.com.vitality.payments_service.domain.service

import br.com.vitality.payments_service.api.dto.input.PagamentoInputDTO
import br.com.vitality.payments_service.api.dto.output.PagamentoOutputDTO
import br.com.vitality.payments_service.domain.model.Pagamento
import br.com.vitality.payments_service.domain.repository.PagamentoRepository
import br.com.vitality.payments_service.domain.service.strategy.ValidarPagamentoFactory
import br.com.vitality.payments_service.domain.service.strategy.ValidarPagamentoStrategy
import br.com.vitality.payments_service.domain.utils.enums.Assinatura
import br.com.vitality.payments_service.domain.utils.enums.StatusPagamento
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Service
import java.util.*

@Service
class PagamentoService(
    private val pagamentoRepository: PagamentoRepository,
    private val validarPagamentoFactory: ValidarPagamentoFactory,
    private val rabbitTemplate: RabbitTemplate) {

    fun persistirPagamento(dto: PagamentoInputDTO) {
        println(dto)

        val idPagamento = UUID.randomUUID().toString()
        val pagamento = Pagamento(
            id = idPagamento,
            idUsuario = dto.idUsuario,
            valor = dto.valor,
            status = StatusPagamento.RECUSADO,
            assinatura = Assinatura.GRATUITA
        )

        validarPagamentoFactory.getEstrategias().forEach { it.validar(pagamento) }

        pagamentoRepository.save(pagamento)

        rabbitTemplate.convertAndSend("payment.made.queue", PagamentoOutputDTO(
            idUsuario = pagamento.idUsuario, assinatura = pagamento.assinatura))
    }
}