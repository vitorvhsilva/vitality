package br.com.vitality.users_service.api.listener;

import br.com.vitality.users_service.api.dto.input.PagamentoOutputDTO;
import br.com.vitality.users_service.domain.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PagamentoFeitoListener {

    private UsuarioService usuarioService;

    @RabbitListener(queues = "payment.made.queue")
    public void mudarAssinatura(@Payload PagamentoOutputDTO dto) {
        System.out.println(dto);
        usuarioService.mudarAssinatura(dto);
    }
}
