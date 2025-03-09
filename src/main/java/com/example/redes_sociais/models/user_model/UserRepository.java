package com.example.redes_sociais.models.user_model;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface UserRepository extends JpaRepository <Usuario, Long> {
    Optional<Usuario> findByUsername(String username);

}
