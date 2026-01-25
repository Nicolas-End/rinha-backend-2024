package rinha_backend_2024.nicolas_end.domain.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;

@Getter
@Setter
@Entity
@Table(name = "Usuario")
public class UserEntity {

    @Autowired
    private UserService userService;

    @Id
    private int id;

    @Column(nullable = false)
    private int limit;

    @Column(nullable = false)
    private double balance;

    @Column
    private String password;

}
