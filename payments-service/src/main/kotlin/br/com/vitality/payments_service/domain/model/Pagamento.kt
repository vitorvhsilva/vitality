package br.com.vitality.payments_service.domain.model

import br.com.vitality.payments_service.domain.utils.enums.StatusPagamento
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.util.UUID

@Document(collection = "pagamentos")
data class Pagamento(
    @Id
    val id: UUID,
    val idUsuario: Long,
    val valor: BigDecimal,
    val status: StatusPagamento)
