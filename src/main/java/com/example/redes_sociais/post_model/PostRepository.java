package com.example.redes_sociais.post_model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Postagem, Long> {

    // Consulta JPQL corrigida para refletir os campos corretos e o relacionamento entre Comentario e Postagem
    @Query("SELECT new com.example.redes_sociais.post_model.PostagemComentarioDTO(p.postagemId, p.conteudo, c.comentId, c.conteudo) " +
            "FROM Postagem p " +
            "INNER JOIN Comentario c ON c.postagem = p " +
            "WHERE p.postagemId = :postagemId")
    List<PostagemComentarioDTO> findComentariosByPostagemId(@Param("postagemId") Long postagemId);

}
