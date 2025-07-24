package org.example.cadastroDeUsuario.infra.exceptions;

public class IdNaoEncontradoException extends RuntimeException {
    public IdNaoEncontradoException(String message) {
        super(message);
    }
}
