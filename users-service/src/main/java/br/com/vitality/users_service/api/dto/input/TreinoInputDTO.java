package br.com.vitality.users_service.api.dto.input;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TreinoInputDTO {
    private Integer idade;
    private Integer genero;
    private Double peso;
    private Double altura;
    public Double calorias;
}
