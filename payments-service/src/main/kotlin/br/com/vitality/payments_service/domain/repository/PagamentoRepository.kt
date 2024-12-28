package br.com.vitality.payments_service.domain.repository

import br.com.vitality.payments_service.domain.model.Pagamento
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.UUID

interface PagamentoRepository: MongoRepository<Pagamento, UUID> {
}