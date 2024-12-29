package br.com.vitality.users_service.api.dto.output;

import lombok.Data;

@Data
public class TreinoOutputDTO {
    private String tipoTreino;
    private Integer frequenciaTreino;
    private Double duracaoTreinoHoras;
}
