package org.example.cadastroDeUsuario.repository;

import org.example.cadastroDeUsuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> { //Repository para trabalhar com o banco de dados
    boolean existsByEmail(String email); //Criei uma Derived Query para saber se um e-mail existe numa coluna da tabela.boolean existsByEmail(String email);
}
