package com.example.redes_sociais.likes_model;


import com.example.redes_sociais.models.user_model.Usuario;
import com.example.redes_sociais.post_model.Postagem;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likesId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "postagem_like_id", nullable = false)
    private Postagem postagem;

    @Column(name = "date_now")
    private Timestamp dateNow;

    @PrePersist
    public void prePersist() {
        if (dateNow == null) {
            // Define the current time as local time
            this.dateNow = new Timestamp(System.currentTimeMillis());
        }
    }
    // Getters and Setters
}