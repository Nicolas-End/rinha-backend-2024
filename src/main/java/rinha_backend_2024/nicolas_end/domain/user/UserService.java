package rinha_backend_2024.nicolas_end.domain.user;


import org.springframework.stereotype.Service;


@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService (UserRepository userRepository){
        this.userRepository = userRepository;
    }


}
