package rinha_backend_2024.nicolas_end.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@Controller
public class HelloController {

    @GetMapping
    public ResponseEntity helloPage(){
        return  ResponseEntity.ok("Olá seja bem-vindo ao minha solução do desafio back-end 2024");
    }
}
