package br.com.vitality.users_service.domain.repository;

import br.com.vitality.users_service.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
