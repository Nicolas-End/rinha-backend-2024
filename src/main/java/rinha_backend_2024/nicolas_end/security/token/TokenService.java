package rinha_backend_2024.nicolas_end.security.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import org.springframework.stereotype.Service;
import rinha_backend_2024.nicolas_end.security.userDetails.UserDetailsIml;

@Service
public class TokenService {
    Algorithm algorithm = Algorithm.HMAC256("Senha de cria");
    public String createToken (UserDetailsIml user) throws JWTCreationException {

        return JWT.create()
                .withIssuer("Nicolas-End")
                .withSubject(user.getUsername())
                .sign(algorithm);


    }

    public String getSubjectToken (String token) throws JWTDecodeException {

        return JWT.require(algorithm)
                .withIssuer("Nicolas-End")
                .build()
                .verify(token)
                .getSubject();

    }
}