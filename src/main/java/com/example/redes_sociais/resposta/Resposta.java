package com.example.redes_sociais.resposta;

import com.example.redes_sociais.model_comentario.Comentario;
import com.example.redes_sociais.models.user_model.Usuario;
import com.example.redes_sociais.post_model.Postagem;
import jakarta.persistence.*;


@Entity
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long respostaId;

    @ManyToOne
    @JoinColumn(name = "postagem_id", nullable = false)
    private Postagem postagem;

    public Long getRespostaId() {
        return respostaId;
    }

    public void setRespostaId(Long respostaId) {
        this.respostaId = respostaId;
    }

    @ManyToOne
    @JoinColumn(name = "comment_id", nullable = false)
    private Comentario comentario;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Usuario usuario;

    private String reply;

    // Getters and Setters


    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }
}
