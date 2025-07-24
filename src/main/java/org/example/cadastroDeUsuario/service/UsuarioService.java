package org.example.cadastroDeUsuario.service;

import jakarta.transaction.Transactional;
import org.example.cadastroDeUsuario.infra.exceptions.EmailJaCadastradoException;
import org.example.cadastroDeUsuario.infra.exceptions.IdNaoEncontradoException;
import org.example.cadastroDeUsuario.model.DadosAtualizadoUsuario;
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

    public Boolean cadastrarUsuario(Usuario usuario){
        if(repository.existsByEmail(usuario.getEmail())){
            throw new EmailJaCadastradoException("O email informado já está cadastrado");
        }else{
            repository.save(usuario);
            return true;
        }
    }

    public List<Usuario> listaDeUsuario(){
        return repository.findAll();
    }

    public Boolean Deletar (Long id){
       if(repository.existsById(id)){
           repository.deleteById(id);
           return true;
       }else{
           return false;
       }
    }
    @Transactional
    public Boolean atualizarUsuario(Long id, DadosAtualizadoUsuario novosDados){
       if(repository.existsById(id)){
           Usuario usuario = repository.findById(id).get();
           usuario.atualizarUsuario(novosDados);
           return true;
       }else{
         throw new IdNaoEncontradoException("o ID digitado não foi encontrado, tente novamente!");
       }
    }

}
