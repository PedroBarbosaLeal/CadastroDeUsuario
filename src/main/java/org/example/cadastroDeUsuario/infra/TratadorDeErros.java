package org.example.cadastroDeUsuario.infra;

import org.example.cadastroDeUsuario.infra.exceptions.EmailJaCadastradoException;
import org.example.cadastroDeUsuario.infra.exceptions.IdNaoEncontrado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(EmailJaCadastradoException.class)
    public ResponseEntity<String> tratarEmailDuplicado(EmailJaCadastradoException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }
    @ExceptionHandler(IdNaoEncontrado.class)
    public ResponseEntity<String> tratarIdNaoEncontrado(IdNaoEncontrado ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
