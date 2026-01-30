package rinha_backend_2024.nicolas_end.controllers;

import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rinha_backend_2024.nicolas_end.domain.user.UserService;

@RequestMapping
@Controller
public class HelloController {
    private final UserService userService;

    public HelloController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity helloPage() throws Exception {
        return  ResponseEntity.ok("Olá seja bem-vindo ao minha solução do desafio back-end 2024");
    }

}
