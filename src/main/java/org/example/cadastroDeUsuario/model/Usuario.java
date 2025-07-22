package org.example.cadastroDeUsuario.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Usuario {

    public Usuario() {
    }

    public void atualizarUsuario(DadosAtualizadoUsuario novosDados){
        this.idade = novosDados.idade();
        this.descricao = novosDados.descricao();
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
