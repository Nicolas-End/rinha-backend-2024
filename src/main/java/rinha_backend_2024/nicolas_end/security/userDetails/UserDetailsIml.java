package rinha_backend_2024.nicolas_end.security.userDetails;

import jakarta.annotation.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import rinha_backend_2024.nicolas_end.domain.user.UserEntity;

import java.util.Collection;
import java.util.List;

public class UserDetailsIml implements UserDetails {
    private final UserEntity user;
    public UserDetailsIml(UserEntity user){
        this.user = user;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public @Nullable String getPassword() {
        /* Diz ao Authentication Manager qual seria a senha para identificar o usuario
         * obs: o usuario é encontrado de acordo com a função no UserDetails Service*/

        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getName();
    }
}
