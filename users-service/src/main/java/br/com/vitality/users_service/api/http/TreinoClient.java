package br.com.vitality.users_service.api.http;

import br.com.vitality.users_service.api.dto.input.TreinoInputDTO;
import br.com.vitality.users_service.api.dto.output.TreinoOutputDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "treino", url = "http://127.0.0.1:5000")
public interface TreinoClient {
    @RequestMapping(method = RequestMethod.POST, value = "/")
    TreinoOutputDTO criarTreino(@RequestBody TreinoInputDTO dto);
}
