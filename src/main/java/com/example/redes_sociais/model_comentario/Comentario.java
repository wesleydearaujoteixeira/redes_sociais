package com.example.redes_sociais.model_comentario;

import com.example.redes_sociais.resposta.Resposta;
import com.example.redes_sociais.likes_comentario.LikesComentario;
import com.example.redes_sociais.models.user_model.Usuario;
import com.example.redes_sociais.post_model.Postagem;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comentId;

    @ManyToOne
    @JoinColumn(name = "postagem_comment_id", nullable = false)
    private Postagem postagem;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Usuario usuario;

    private String conteudo;

    @OneToMany(mappedBy = "comentario")
    private List<LikesComentario> likes;

    @OneToMany(mappedBy = "comentario")
    private List<Resposta> respostas;

    // Getters and Setters

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}