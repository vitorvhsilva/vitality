package br.com.vitality.payments_service.domain.model

import br.com.vitality.payments_service.domain.utils.enums.Assinatura
import br.com.vitality.payments_service.domain.utils.enums.StatusPagamento
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal

@Document(collection = "pagamentos")
data class Pagamento(
    @Id
    val id: String,
    val idUsuario: Long,
    val valor: BigDecimal,
    var status: StatusPagamento,
    var assinatura: Assinatura)
