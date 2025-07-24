package org.example.cadastroDeUsuario.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

//DTO para receber os dados de atualização
public record DadosAtualizadoUsuario(

        @NotNull(message = "Espaço obrigatório")
        int idade,

        @NotBlank(message = "Digite uma descrição")
        String descricao) {
}
