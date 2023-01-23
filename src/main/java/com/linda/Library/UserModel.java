package com.linda.Library;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="USERS")
@Getter
@Setter
public class UserModel implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long userId;
    private String userName;
    public String  Password;

    private List<String> authorities;
    private boolean isAccountNonExpired ;
    private boolean isAccountNonLocked ;
    private boolean isCredentialsNonExpired ;
    private boolean isEnabled ;
    public boolean enabled = true;

    public String role = "ROLE_USER";

    public String email;
    public String firstName;
    public String lastName;


    @OneToMany(mappedBy = "reservedByUser")
    private List<Books> reservedBooks;
    @OneToMany(mappedBy = "theUser")
    private List<Books> books;



    public UserModel(){}

    public UserModel(String userName, String password, List<String> authorities, boolean isAccountNonExpired, boolean isAccountNonLocked, boolean isCredentialsNonExpired, boolean isEnabled, boolean enabled, String role, String email, String firstName, String lastName, List<Books> reservedBooks, List<Books> books) {
        this.userName = userName;
        Password = password;
        this.authorities = authorities;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;
        /*this.enabled = enabled;
        this.role = role;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.reservedBooks = reservedBooks;
        this.books = books;*/
    }

    public UserModel(String encode, String benny, List<SimpleGrantedAuthority> grantedAuthorities, boolean b, boolean b1, boolean b2, boolean b3) {
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public String  getPassword(){
        return Password;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority > authorityList = new ArrayList <>();
        return authorityList ;

    }
    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }
    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }
}
