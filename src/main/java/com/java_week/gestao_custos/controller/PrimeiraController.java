package com.java_week.gestao_custos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RequestMapping("/javadevweek")
@RestController
public class PrimeiraController {

    @PostMapping("/create")
    public void create(@RequestBody String entity) {



    }


    @GetMapping
    public String helloWorld() {
        System.err.println("Olá, Dev Week! Bem-vindo à Gestão de Custos Pessoais!");
        return "Olá, Dev Week! Bem-vindo à Gestão de Custos Pessoais!";
    }

}
