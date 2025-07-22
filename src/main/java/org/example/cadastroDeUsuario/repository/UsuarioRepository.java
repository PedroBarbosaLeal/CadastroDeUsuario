package org.example.cadastroDeUsuario.repository;

import org.example.cadastroDeUsuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
