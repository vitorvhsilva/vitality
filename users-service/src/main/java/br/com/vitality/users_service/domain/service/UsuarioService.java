package br.com.vitality.users_service.domain.service;

import br.com.vitality.users_service.api.dto.input.CadastroUsuarioDTO;
import br.com.vitality.users_service.domain.model.Usuario;
import br.com.vitality.users_service.domain.repository.UsuarioRepository;
import br.com.vitality.users_service.domain.utils.enums.Assinatura;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioService {
    private UsuarioRepository usuarioRepository;
    private ModelMapper modelMapper;

    public ResponseEntity<Void> cadastrar(CadastroUsuarioDTO dto) {
        Usuario usuario = modelMapper.map(dto, Usuario.class);
        usuario.setAssinatura(Assinatura.GRATUITA);
        usuarioRepository.save(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
