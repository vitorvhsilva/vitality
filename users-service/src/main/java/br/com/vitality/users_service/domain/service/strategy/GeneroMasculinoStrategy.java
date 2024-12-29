package br.com.vitality.users_service.domain.service.strategy;

import br.com.vitality.users_service.domain.utils.enums.Genero;
import org.springframework.stereotype.Component;

@Component
public class GeneroMasculinoStrategy implements DeparaGeneroStrategy{
    @Override
    public Integer deparaGenero(Genero genero) {
        if (genero.equals(Genero.MASCULINO)) {
            return 0;
        }
        return null;
    }
}
