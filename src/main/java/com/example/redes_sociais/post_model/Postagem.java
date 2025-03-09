package com.example.redes_sociais.post_model;


import com.example.redes_sociais.likes_model.Likes;
import com.example.redes_sociais.model_comentario.Comentario;
import com.example.redes_sociais.models.user_model.Usuario;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Postagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postagem_id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Usuario usuario;


    public Long getPostagem_id(){
        return postagem_id;
    }
    public Long getUsuarioId(){
        return this.usuario.getId();
    }

    public Usuario setUsuario(Usuario usuario){
        return this.usuario = usuario;
    }

    private String conteudo;

    @OneToMany(mappedBy = "postagem")

    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "postagem")

    private List<Likes> likes;

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}
