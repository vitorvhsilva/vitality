package br.com.vitality.payments_service.domain.repository

import br.com.vitality.payments_service.domain.model.Pagamento
import org.springframework.data.mongodb.repository.MongoRepository

interface PagamentoRepository: MongoRepository<Pagamento, String> {
}