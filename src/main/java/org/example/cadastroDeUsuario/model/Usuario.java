package org.example.cadastroDeUsuario.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Este é um campo obrigatório")
    private String nome;

    @NotNull(message = "Adicione sua idade")
    private int  idade;

    @Email(message = "Email inválido")
    @NotBlank(message = "Este é um campo obrigatório")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Adicione uma descricao")
    private String descricao;
}
