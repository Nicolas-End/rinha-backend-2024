package rinha_backend_2024.nicolas_end.domain.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Usuario")
public class UserEntity {

    @Id
    private int id;

    @Column(nullable = false)
    private int limit;

    @Column(nullable = false)
    private double balance;

}
