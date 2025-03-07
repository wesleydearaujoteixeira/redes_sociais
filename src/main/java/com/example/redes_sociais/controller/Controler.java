package com.example.redes_sociais.controller;


import com.example.redes_sociais.models.user_model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/redes")
public class Controler {

    @GetMapping("/vai")
    public String Deucerto() {
        return " Deu certo essa bagaça";
    }

}
