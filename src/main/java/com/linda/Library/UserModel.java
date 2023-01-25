package com.linda.Library;
import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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
    @NotEmpty
   // @Email - här kan man sätta email som användenamn
    private String userName;
    @NotEmpty
    @Size(min =6, max= 50)
    public String  Password;

    private List<String> authorities;
    @AssertTrue
    private boolean isAccountNonExpired ;
    private boolean isAccountNonLocked ;
    private boolean isCredentialsNonExpired ;
    private boolean isEnabled ;
    public boolean enabled = true;

    public String role = "ROLE_USER";
    @Email
    public String email;
    public String firstName;
    public String lastName;

    // Debugging purposes only
    // TODO - delete Later
   /* @Override
    public String toString() {
        return "UserModel{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", Password='" + Password + '\'' +
                ", authorities=" + authorities +
                ", isAccountNonExpired=" + isAccountNonExpired +
                ", isAccountNonLocked=" + isAccountNonLocked +
                ", isCredentialsNonExpired=" + isCredentialsNonExpired +
                ", isEnabled=" + isEnabled +
                ", enabled=" + enabled +
                ", role='" + role + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }*/
    /*@OneToMany(mappedBy = "reservedByUser")
    private List<Books> reservedBooks;
    @OneToMany(mappedBy = "theUser")
    private List<Books> books;*/



    public UserModel(){}

    public UserModel(String userName, String password, List<String> authorities, boolean isAccountNonExpired, boolean isAccountNonLocked, boolean isCredentialsNonExpired, boolean isEnabled, boolean enabled, String role, String email, String firstName, String lastName, List<Books> reservedBooks, List<Books> books) {
        this.userName = userName;
        Password = password;
        this.authorities = authorities;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;
    }

    public UserModel(String encode, String benny, List<SimpleGrantedAuthority> grantedAuthorities, boolean b, boolean b1, boolean b2, boolean b3) {
    }



    @Override
    public String  getPassword(){
        return Password;
    }

    @Override
    public String getUsername() {
        return null;
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
