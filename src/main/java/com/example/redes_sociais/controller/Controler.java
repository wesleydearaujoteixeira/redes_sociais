package com.example.redes_sociais.controller;


import com.example.redes_sociais.models.user_model.UserRepository;
import com.example.redes_sociais.models.user_model.UserServices;
import com.example.redes_sociais.models.user_model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/redes")
public class Controler {

    @Autowired
    private UserServices userRepo;

    @Autowired
    private PasswordEncoder encoder;

    @PostMapping("/cadastrar")

    public ResponseEntity<?> CadastrarNoSistema(@RequestBody Usuario user) {

        boolean userExist = userRepo.verifyCredentials(user.getUsername(), user.getPassword());

        if(!userExist){
            Usuario usuario = userRepo.CadastrarUser(user);
            return ResponseEntity.status(HttpStatus.OK).body("Usuário Criado com sucesso");
        }

        return ResponseEntity.badRequest().build();



    }

    @GetMapping("/listarUsers")
    public List<Usuario> ListarUsuários (){
        List<Usuario> users = userRepo.ListarUsuários();
        return users;

    }

    @PostMapping("/login")
    public  ResponseEntity<?> Login (@RequestBody Usuario user) {

        boolean usuarioLogado = userRepo.verifyCredentials(user.getUsername(), user.getPassword());

        if(usuarioLogado){
            return ResponseEntity.status(HttpStatus.OK).body(" Usuário logado");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" Usuário não encontrado");


    }







}
