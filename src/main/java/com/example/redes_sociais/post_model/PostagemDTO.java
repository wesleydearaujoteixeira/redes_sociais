package com.example.redes_sociais.post_model;

public class PostagemDTO {

        private Long user_id;
        private String conteudo;

        // Getters and Setters
        public Long getUserId() {
            return user_id;
        }

        public void setUserId(Long user_id) {
            this.user_id = user_id;
        }

        public String getConteudo() {
            return conteudo;
        }

        public void setConteudo(String conteudo) {
            this.conteudo = conteudo;
        }
    }


