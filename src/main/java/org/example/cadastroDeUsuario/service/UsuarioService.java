package org.example.cadastroDeUsuario.service;

import org.example.cadastroDeUsuario.model.Usuario;
import org.example.cadastroDeUsuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository){
        this.repository = repository;
    }

    public void cadastrarUsuario(Usuario usuario){
        repository.save(usuario);
    }

    public List<Usuario> listaDeUsuario(){
        return repository.findAll();
    }

}
