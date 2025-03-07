package com.example.redes_sociais.reply_resposta;

import com.example.redes_sociais.models.user_model.Usuario;
import com.example.redes_sociais.resposta.Resposta;
import jakarta.persistence.*;

@Entity
public class ReplyResposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reply_respos_id;

    @ManyToOne
    @JoinColumn(name = "resposta_res_id", nullable = false)
    private Resposta resposta;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Usuario usuario;

    private String replyResposta;
}
