package com.example.redes_sociais.post_model;


import com.example.redes_sociais.models.user_model.UserRepository;
import com.example.redes_sociais.models.user_model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostagemService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository usuarioRepository;

    // Método para criar uma postagem
    public Postagem criarPostagem(Long userId, String conteudo) {
        // Buscar o usuário pelo ID
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(userId);



        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();

            // Criar uma nova postagem
            Postagem postagem = new Postagem();
            postagem.setUsuario(usuario);
            postagem.setConteudo(conteudo);

            // Salvar a postagem no banco de dados
            return postRepository.save(postagem);
        } else {
            throw new RuntimeException("Usuário não encontrado");
        }
    }

    public List<Postagem> listPosts(Postagem posts){
        return postRepository.findAll();
    }


}