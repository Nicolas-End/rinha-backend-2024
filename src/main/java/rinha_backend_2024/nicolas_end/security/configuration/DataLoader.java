package rinha_backend_2024.nicolas_end.security.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rinha_backend_2024.nicolas_end.domain.user.UserEntity;
import rinha_backend_2024.nicolas_end.domain.user.UserRepository;

// Inseri o dados no banco de dados
// assim que inicia o progama
@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository) {
        return args -> {
            // caso n tenha nenhum usuario cadastro o sistema cadastar alguns usuario automaticamente
            if (userRepository.count() == 0) {
                String password = "123456";
                UserEntity user1 = new UserEntity(1,"Carlos",100000,0,password);
                UserEntity user2 = new UserEntity(2,"Maria",80000,0,password);
                UserEntity user3 = new UserEntity(3,"João",1000000,0,password);
                UserEntity user4 = new UserEntity(4,"Kleber",10000000,0,password);
                UserEntity user5 = new UserEntity(5,"Tays",500000,0,password);

                userRepository.save(user1);
                userRepository.save(user2);
                userRepository.save(user3);
                userRepository.save(user4);
                userRepository.save(user5);


            }
        };
    }
}
