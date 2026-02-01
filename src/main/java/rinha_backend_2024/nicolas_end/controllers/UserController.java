package rinha_backend_2024.nicolas_end.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class UserController {
    @PostMapping("/login")
    public ResponseEntity userLogin(){
        return ResponseEntity.ok("tudo certo");
    }
}
