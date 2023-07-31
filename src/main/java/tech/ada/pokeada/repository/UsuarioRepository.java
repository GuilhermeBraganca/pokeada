package tech.ada.pokeada.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.ada.pokeada.model.User;

public interface UsuarioRepository extends JpaRepository<User, Long> { }
