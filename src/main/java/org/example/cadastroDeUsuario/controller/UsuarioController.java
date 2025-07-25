package org.example.cadastroDeUsuario.controller;

import jakarta.validation.Valid;
import org.example.cadastroDeUsuario.model.DadosAtualizadoUsuario;
import org.example.cadastroDeUsuario.model.Usuario;
import org.example.cadastroDeUsuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping("/usuarios")
    public ResponseEntity cadastrar(@RequestBody @Valid Usuario usuario) {
        service.cadastrarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {
        List<Usuario> usuarios = service.listaDeUsuario();
        return ResponseEntity.ok(usuarios);
    }

    @DeleteMapping("/deletarUsuario/{id}")
    public ResponseEntity<?> deletarUsuario(@PathVariable Long id) {
        Boolean usuario = service.Deletar(id);
        if (usuario) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody DadosAtualizadoUsuario novosDaddos) {
        service.atualizarUsuario(id, novosDaddos);
        return ResponseEntity.ok().body(novosDaddos);
    }
}
