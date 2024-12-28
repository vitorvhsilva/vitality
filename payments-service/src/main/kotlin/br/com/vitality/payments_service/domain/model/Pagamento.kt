package br.com.vitality.payments_service.domain.model

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "pagamentos")
data class Pagamento(val id: Long)
