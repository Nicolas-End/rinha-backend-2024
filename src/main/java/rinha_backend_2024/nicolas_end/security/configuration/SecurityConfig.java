package rinha_backend_2024.nicolas_end.security.configuration;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.io.IOException;

@Configuration
public class SecurityConfig  {
    @Bean
    public SecurityFilterChain SecurityCOnfig(HttpSecurity http) throws Exception{
        return  http
                .authorizeHttpRequests( (authorizate) -> authorizate
                        .anyRequest().permitAll()
                )
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        /* Essa função Autentifica o usuario por meio das funções presentes no
         * UserDetails, UserDetailsService e a função PasswordEncoder Logo Abaixo*/

        return  authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        /*Diz ao Authentificator qual é o tipo de codificação da senha em questão*/
        return  new BCryptPasswordEncoder();
    }
}
