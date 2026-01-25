package rinha_backend_2024.nicolas_end.security.configuration;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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
}
