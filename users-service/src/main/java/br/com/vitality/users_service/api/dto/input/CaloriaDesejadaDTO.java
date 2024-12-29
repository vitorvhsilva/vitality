package br.com.vitality.users_service.api.dto.input;

import lombok.Data;

@Data
public class CaloriaDesejadaDTO {
    private Long idUsuario;
    private Double calorias;
}
