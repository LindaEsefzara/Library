package com.linda.Library.Service;

import com.linda.Library.Repository.UserModelRepository;
import com.linda.Library.UserModel;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Entity
@Service
public class UserModelService implements UserDetailsService {

    private final UserModelRepository userModelRepository;

    public UserModelService(UserModelRepository userRepositoryModel) {
        this.userModelRepository = userRepositoryModel;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // TODO- Exception handling

        return userModelRepository.findByUsername(username);
    }

    @Autowired
    // TODO - Save User
    public void save(UserModel user) {
        userModelRepository.save(user);
    }

    public void saveById(long userId) {
        UserModel user = userModelRepository.findById(userId).get();
        userModelRepository.save(user);
    }


    public UserModel findById(long id){
        UserModel user = userModelRepository.findById(id).get();
        return user;
    }

    public List<UserModel> findAll(){
        return (List<UserModel>) userModelRepository.findAll();
    }

    public List<UserModel> userSearcher(String firstName, String lastName) {
        if
        (firstName != null && lastName != null) {
            return getByFullName(firstName, lastName);

        } else if
        (firstName == null && lastName != null){
            return getByLastName(lastName);

        }else if
            (firstName == null && lastName !=null) {
            return getByFirstName(firstName);

        } else return new ArrayList<UserModel>();

    }


    public List<UserModel> getByFirstName(String firstName){
        List<UserModel> users = new ArrayList<UserModel>();
        for (UserModel user : userModelRepository.findAll()) {
            if (user.getFirstName().toLowerCase().contains(firstName.toLowerCase())) {
                users.add(user);
            }
        }
        return users;
    }

    public List<UserModel> getByLastName(String lastName){
        List<UserModel> users = new ArrayList<UserModel>();
        for (UserModel user : userModelRepository.findAll()) {
            if(user.getLastName().toLowerCase().contains(lastName.toLowerCase())) {
                users.add(user);
            }
        }
        return users;
    }

    public List<UserModel> getByFullName(String firstName, String lastName){
        List<UserModel> users = new ArrayList<UserModel>();
        for (UserModel user : userModelRepository.findAll()) {
            if (user.getFirstName().toLowerCase().contains(firstName.toLowerCase()) &&
                    user.getLastName().toLowerCase().contains(lastName.toLowerCase())) {
                users.add(user);
            }
        }
        return users;
    }
}

