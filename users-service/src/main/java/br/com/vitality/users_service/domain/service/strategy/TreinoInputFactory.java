package br.com.vitality.users_service.domain.service.strategy;

import br.com.vitality.users_service.api.dto.input.CaloriaDesejadaDTO;
import br.com.vitality.users_service.api.dto.input.TreinoInputDTO;
import br.com.vitality.users_service.domain.model.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@AllArgsConstructor
public class TreinoInputFactory {

    private List<DeparaGeneroStrategy> strategies;

    public TreinoInputDTO criarTreinoInput(Usuario usuario, CaloriaDesejadaDTO dto){
        Integer genero = strategies.stream()
                .map(s -> s.deparaGenero(usuario.getGenero()))
                .filter(Objects::nonNull)
                .findFirst()
                .orElse(null);

        return new TreinoInputDTO(usuario.getIdade(), genero, usuario.getPeso(), usuario.getAltura(), dto.getCalorias());
    }
}
