package rinha_backend_2024.nicolas_end.security.token;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import rinha_backend_2024.nicolas_end.domain.user.UserEntity;

@Component
public class AuthenticatedUser {

    public UserEntity get(){
        return (UserEntity) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
    }

}