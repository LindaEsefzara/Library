package com.linda.Library.Service;

import com.linda.Library.Repository.UserRepository;
import com.linda.Library.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;


    public void save(User user) {
        userRepository.save(user);
    }

    public void saveById(long userId) {
        User user = userRepository.findById(userId).get();
        userRepository.save(user);
    }


    public User findById(long userId){
        User user = userRepository.findById(userId).get();
        return user;
    }

    public List<User> findAll(){
        return (List<User>) userRepository.findAll();
    }

    public List<User> userSearcher(String userName, String email) {
        if
        (userName != null && email != null) {
            return findAll();

        }else if
            (userName == null && email !=null) {
            return findAll();

        } else return new ArrayList<>();

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public User findUserByEmail(String email) {
        return null;
    }

    public ResponseEntity<User> updateUser(Long user_id, User user) {
        try{
            Optional<User> userOptional = userRepository.findById(user_id);
            User userEntity = userOptional.get();

            userEntity.setUsername(user.getUsername());
            userEntity.setPassword(user.getPassword());
            userEntity.setEmail(user.getEmail());
            userRepository.save(userEntity);
            return new ResponseEntity<>(userEntity, HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public void deleteUser(@PathVariable("user_id") Long user_id) {
        try {
            userRepository.deleteById(user_id);
            System.out.println(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            System.out.println(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<User>> showUsers() {
        try {
            return ResponseEntity.ok((List<User>) this.userRepository.findAll());
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

