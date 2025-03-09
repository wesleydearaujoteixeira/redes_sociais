package com.example.redes_sociais.models.user_model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    public Usuario CadastrarUser (Usuario user) {
        return userRepository.save(user);
    }

    public List<Usuario> ListarUsuários () {
        return userRepository.findAll();
    }


    public boolean verifyCredentials(String name, String password) {

        Optional<Usuario> usuarioAuth = userRepository.findByUsername(name);

        if(usuarioAuth.isPresent()){

            Usuario usuarioSystem = usuarioAuth.get();

            return encoder.matches(password, usuarioSystem.getPassword());

        }

        return false;

    }




}
