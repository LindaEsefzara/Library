package com.linda.Library;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import javax.sql.DataSource;
import java.util.List;

@Entity
@Table(name="USERS")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long userId;
    public String userName;
    public int Password;

    public boolean enabled = true;

    public String role = "ROLE_USER";

    public String email;
    public String firstName;
    public String lastName;


    @OneToMany(mappedBy = "reservedByUser")
    private List<Books> reservedBooks;

    @OneToMany(mappedBy = "theUser")
    private List<Books> books;



    public User(){}

    public User(String userName, int password, boolean enabled, String role, String email, String firstName, String lastName) {
        this.userName = userName;
        Password = password;
        this.enabled = enabled;
        this.role = role;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;

    }
}
