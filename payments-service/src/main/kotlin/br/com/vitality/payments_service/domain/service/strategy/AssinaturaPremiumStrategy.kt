package br.com.vitality.payments_service.domain.service.strategy

import br.com.vitality.payments_service.domain.model.Pagamento
import br.com.vitality.payments_service.domain.utils.enums.Assinatura
import br.com.vitality.payments_service.domain.utils.enums.StatusPagamento
import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component
class AssinaturaPremiumStrategy: ValidarPagamentoStrategy {
    override fun validar(pagamento: Pagamento){
        if (pagamento.valor.compareTo(BigDecimal(50)) == 0) {
            pagamento.assinatura = Assinatura.PREMIUM
            pagamento.status = StatusPagamento.APROVADO
        }
    }
}