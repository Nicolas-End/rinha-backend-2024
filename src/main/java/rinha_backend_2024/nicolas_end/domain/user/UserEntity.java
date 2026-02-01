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

    public UserEntity (int id,String name,int creditLimit, double balance, String password){
        setId(id);
        setName(name);
        setCreditLimit(creditLimit);
        setBalance(balance);
        setPassword(password);

    }
    public UserEntity(){

    }

    @Id
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int creditLimit;

    @Column(nullable = false)
    private double balance;

    @Column
    private String password;

}
