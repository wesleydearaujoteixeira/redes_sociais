package com.example.redes_sociais.likes_comentario;

import com.example.redes_sociais.model_comentario.Comentario;
import com.example.redes_sociais.models.user_model.Usuario;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class LikeComentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeComentarioId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "comentario_like_id", nullable = false)
    private Comentario comentario;

    @Column(name = "date_now")
    private Timestamp dateNow;

    // Getters and Setters
}
