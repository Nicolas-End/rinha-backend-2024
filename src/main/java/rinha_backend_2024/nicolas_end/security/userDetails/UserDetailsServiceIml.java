package rinha_backend_2024.nicolas_end.security.userDetails;

import lombok.NonNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import rinha_backend_2024.nicolas_end.domain.user.UserEntity;
import rinha_backend_2024.nicolas_end.domain.user.UserRepository;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class UserDetailsServiceIml implements UserDetailsService {

    private UserRepository userRepository;
    public UserDetailsServiceIml(UserRepository userRepository){
        this.userRepository = userRepository;
    }




    @Override
    public UserDetails loadUserByUsername(@NonNull String id) throws UsernameNotFoundException {

        int userId = Integer.parseInt(id);

        UserEntity user = userRepository.findById(userId).orElse(null);
        return new UserDetailsIml(user);

    }


}