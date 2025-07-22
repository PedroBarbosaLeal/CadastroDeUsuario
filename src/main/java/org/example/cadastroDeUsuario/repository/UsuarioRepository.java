package org.example.cadastroDeUsuario.repository;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.example.cadastroDeUsuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    boolean existsByEmail(String email);

    boolean existsByNome(String nome);
}
