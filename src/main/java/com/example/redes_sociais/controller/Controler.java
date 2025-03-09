package com.example.redes_sociais.controller;


import com.example.redes_sociais.models.user_model.UserRepository;
import com.example.redes_sociais.models.user_model.UserServices;
import com.example.redes_sociais.models.user_model.Usuario;
import com.example.redes_sociais.post_model.*;
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

    @Autowired
    PostagemService postagemService;

    @Autowired
    PostRepository postRepo;

    @PostMapping("/cadastrar")

    public ResponseEntity<?> CadastrarNoSistema(@RequestBody Usuario user) {

        boolean userExist = userRepo.verifyCredentials(user.getUsername(), user.getPassword());

        if(!userExist){
            Usuario usuario = userRepo.CadastrarUser(user);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .header("user-id", usuario.getId().toString())
                    .body("Usuário Criado com sucesso");
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

    @PostMapping("/post")
    public ResponseEntity<?>  Post(@RequestBody PostagemDTO postagemDTO) {

        System.out.println("Usuário ID: " + postagemDTO.getUserId());
        System.out.println("Conteúdo: " + postagemDTO.getConteudo());
        try {
            // Chama o serviço para criar a postagem
            Postagem novaPostagem = postagemService.criarPostagem(postagemDTO.getUserId(), postagemDTO.getConteudo());
            // Retorna a postagem criada com o status CREATED (201)
            return ResponseEntity.status(HttpStatus.CREATED).body(novaPostagem);
        } catch (RuntimeException e) {
            // Se o usuário não for encontrado, retorna BAD REQUEST
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" ssdsdls ");
        }
    }

    @GetMapping("/post/list")

    public ResponseEntity<?> list(Postagem postes) {
        List<Postagem> posts = postagemService.listPosts(postes);

        if(!posts.isEmpty()){
            return ResponseEntity.ok(posts);
        }

        return ResponseEntity.badRequest().build();
    }






}








