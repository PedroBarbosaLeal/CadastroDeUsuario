package org.example.cadastroDeUsuario.controller;
import jakarta.validation.Valid;
import org.example.cadastroDeUsuario.model.Usuario;
import org.example.cadastroDeUsuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.Location;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping("/usuarios")
    public ResponseEntity cadastrar(@RequestBody @Valid Usuario usuario){
        service.cadastrarUsuario(usuario);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listar(){
        List<Usuario> usuarios = service.listaDeUsuario();
        return ResponseEntity.ok(usuarios);
    }
}
