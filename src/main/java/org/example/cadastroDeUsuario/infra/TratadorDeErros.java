package org.example.cadastroDeUsuario.infra;

import org.example.cadastroDeUsuario.infra.exceptions.EmailJaCadastradoException;
import org.example.cadastroDeUsuario.infra.exceptions.IdNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros { /*Aqui eu usei um RestControllerAdvice para controlar
                               os erros mais comuns da minha aplicação sem precisar fazer Try Catch,
                               deixando o código mais limpo.
                               */

    @ExceptionHandler(EmailJaCadastradoException.class)
    public ResponseEntity<String> tratarEmailDuplicado(EmailJaCadastradoException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(IdNaoEncontradoException.class)
    public ResponseEntity<String> tratarIdNaoEncontrado(IdNaoEncontradoException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
