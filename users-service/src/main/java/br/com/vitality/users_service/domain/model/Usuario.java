package br.com.vitality.users_service.domain.model;

import br.com.vitality.users_service.domain.utils.enums.Assinatura;
import br.com.vitality.users_service.domain.utils.enums.Genero;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @Size(min = 3)
    private String nome;
    @Email
    private String email;
    @NotBlank @Size(min = 8)
    private String senha;
    @NotNull @Positive
    private Integer idade;
    @Enumerated(value = EnumType.STRING)
    private Genero genero;
    @NotNull @Positive
    private Double altura;
    @NotNull @Positive
    private Double peso;
    @Enumerated(value = EnumType.STRING)
    private Assinatura assinatura;

}
