package rinha_backend_2024.nicolas_end.security.token;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import rinha_backend_2024.nicolas_end.domain.user.UserEntity;
import rinha_backend_2024.nicolas_end.domain.user.UserRepository;
import rinha_backend_2024.nicolas_end.security.userDetails.UserDetailsIml;

import java.io.IOException;

@Component
public class TokenFilter extends OncePerRequestFilter {
    private final TokenService tokenService;
    private final UserRepository userRepository;

    public TokenFilter(TokenService tokenService, UserRepository userRepository){
        this.tokenService = tokenService;
        this.userRepository = userRepository;
    }




    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // verifica se o usuario tem algum token no hearder
        String token = getToken(request);
        if (token != null){

            // pega o email do usuario guardado no token
            String name = this.tokenService.getSubjectToken(token);


            UserEntity user = this.userRepository.findByName(name);

            UserDetailsIml userDetailsIml = new UserDetailsIml(user);

            // Encapsula os dados do usuario
            var authetication = new UsernamePasswordAuthenticationToken(userDetailsIml, null, userDetailsIml.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authetication);
        }
        filterChain.doFilter(request, response);

    }
    private String getToken(HttpServletRequest request){
        String authorizationHeader = request.getHeader("Authorization");

        if(authorizationHeader != null) {
            return authorizationHeader.replace("Bearer ", "");
        }
        return null;
    }
}