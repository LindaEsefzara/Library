package com.linda.Library.Service;

import com.linda.Library.Repository.UserRepository;
import com.linda.Library.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
}

