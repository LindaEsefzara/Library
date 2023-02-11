package com.linda.Library.Controller;

import com.linda.Library.Configuration.AppPasswordConfig;
import com.linda.Library.Repository.UserRepository;
import com.linda.Library.Model.User;
import com.linda.Library.Service.UserService;
import com.linda.Library.authorites.UserRoles;
import jakarta.validation.Valid;
import org.apache.el.lang.FunctionMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.awt.print.Book;
import java.util.List;
import java.util.Map;


@Controller

public class UserController {
    private final UserRepository userRepository;
    private final AppPasswordConfig appPasswordConfig;
    private final UserService userService;


    @Autowired
    public UserController(UserRepository userRepository, AppPasswordConfig appPasswordConfig, UserService userService) {
        this.userRepository = userRepository;
        this.appPasswordConfig = appPasswordConfig;
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> showUsers() {
        return userService.showUsers();
    }

    @DeleteMapping("/user_id")
    public void deleteUser(@PathVariable("user_id") Long user_id) {
        userService.findById(user_id);
    }

    @PutMapping("/user_id")
    public ResponseEntity<User> updateUser(@PathVariable Long user_id, @RequestBody final User user) {
        return userService.updateUser(user_id, user);
    }
}

