package br.com.walkito.fichaOnline.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "teste")
public class Teste {

    @GetMapping
    public String teste(){
        return "Olá Mundo2525255";
    }
}
