package br.com.vitality.users_service.domain.service.strategy;

import br.com.vitality.users_service.domain.utils.enums.Genero;
import org.springframework.stereotype.Component;

@Component
public class GeneroFemininoStrategy implements DeparaGeneroStrategy{
    @Override
    public Integer deparaGenero(Genero genero) {
        if (genero.equals(Genero.FEMININO)) {
            return 1;
        }
        return null;
    }
}
