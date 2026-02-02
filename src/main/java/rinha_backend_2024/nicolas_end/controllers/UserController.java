package rinha_backend_2024.nicolas_end.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import rinha_backend_2024.nicolas_end.domain.user.UserService;
import rinha_backend_2024.nicolas_end.dtos.user.LoginResponseDTO;
import rinha_backend_2024.nicolas_end.dtos.user.UserLogin;

@Service
public class UserController {

    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity userLogin(@RequestBody UserLogin datas){
        return this.userService.userLogin(datas);
    }
}
