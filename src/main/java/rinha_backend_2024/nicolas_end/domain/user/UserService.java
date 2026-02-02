package rinha_backend_2024.nicolas_end.domain.user;


import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import rinha_backend_2024.nicolas_end.dtos.user.LoginResponseDTO;
import rinha_backend_2024.nicolas_end.dtos.user.UserLogin;
import rinha_backend_2024.nicolas_end.security.token.TokenService;
import rinha_backend_2024.nicolas_end.security.userDetails.UserDetailsIml;

import java.util.Objects;


@Service
public class UserService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final TokenService tokenService;


    public UserService (UserRepository userRepository, TokenService tokenService, AuthenticationManager authenticationManager){
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    public ResponseEntity userLogin(UserLogin data){
        var usenamePassword = new UsernamePasswordAuthenticationToken(data.id(), data.password());
        var auth = this.authenticationManager.authenticate(usenamePassword);

        var token = tokenService.createToken((UserDetailsIml) Objects.requireNonNull(auth.getPrincipal()));

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
}
