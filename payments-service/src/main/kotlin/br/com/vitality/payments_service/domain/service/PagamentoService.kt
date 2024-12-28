package br.com.vitality.payments_service.domain.service

import br.com.vitality.payments_service.api.dto.input.PagamentoInputDTO
import br.com.vitality.payments_service.domain.model.Pagamento
import br.com.vitality.payments_service.domain.repository.PagamentoRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class PagamentoService(private val pagamentoRepository: PagamentoRepository) {

    fun persistirPagamento(dto: PagamentoInputDTO) {
        val idPagamento = UUID.randomUUID()

//        pagamentoRepository.findById(idPagamento).orElseThrow({NotFoundEx})
//
//        val pagamento = Pagamento(UUID.randomUUID(), )
    }
}