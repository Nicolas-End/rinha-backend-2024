package rinha_backend_2024.nicolas_end.domain.user;

import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import rinha_backend_2024.nicolas_end.dtos.user.UsersDatas;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public boolean initializerUsers() throws Exception {
        for (int i = 1; i < 7; i++) {
            if(i != 5){
                this.generateUser(new UsersDatas(i,i*1000,"senha123"));
            }
        }
        return true;
    }


    @Transactional
    private boolean generateUser(UsersDatas datas) throws Exception{
        
        if (userRepository.findById(datas.id()).isPresent()) return false;
        
        String encryptedPassword = new BCryptPasswordEncoder().encode(datas.password());
        UserEntity user = new UserEntity();
        user.setId(datas.id());
        user.setLimit(datas.limit());
        user.setBalance(0);
        user.setPassword(encryptedPassword);
    
        this.userRepository.save(user);
        return true;
    }
}
