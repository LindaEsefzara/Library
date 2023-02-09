package com.linda.Library.Controller;

import com.linda.Library.Configuration.AppPasswordConfig;
import com.linda.Library.Repository.UserRepository;
import com.linda.Library.Model.User;
import com.linda.Library.Service.UserService;
import com.linda.Library.authorites.UserRoles;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.awt.*;
import java.io.IOException;
import java.net.URI;


@Controller
public class UserController<function> {
    private final UserRepository userRepository;
    private final AppPasswordConfig appPasswordConfig;
    private final UserService userService;



    @Autowired
    public UserController(UserRepository userRepository, AppPasswordConfig appPasswordConfig, UserService userService) {
        this.userRepository = userRepository;
        this.appPasswordConfig = appPasswordConfig;
        this.userService = userService;
    }
    @GetMapping(value="/login")
    public String login() {
        return "login.html";
    }

    @GetMapping(value="/logout")
    public String logout() {
        return "logout.html";
    }

    @GetMapping("/register")
    public String displayRegisterUser(User user) {    // THIS ARGUMENT MUST EXIST

        return "register.html";
    }

    @PostMapping("/register")
    public String registerUser(@Valid User user, BindingResult result, Model model) {

        if (result.hasErrors()) {

            return "register";
        }

        String role = String.valueOf(user.getAuthorities().iterator().next());

        switch (role) {
            case "Admin" ->  user.setAuthorities(UserRoles.ADMIN.getGrantedAuthorities());
            case "User" -> user.setAuthorities(UserRoles.USER.getGrantedAuthorities());
        }
        user.setPassword(appPasswordConfig.bCryptPasswordEncoder().encode(user.getPassword()));
        user.setEmail(user.getEmail());
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);

        // IF no errors
        System.out.println(user);
        userRepository.save(user);
        //model.addAttribute("user", userModel);

        return "header";
    }




   /* @GetMapping("/Book")
    function getBooks(){
        document.getElementById('output').innerHTML="";
        fetch("http://openlibrary.org/search.json?q="
                +document.getElementById("input").value)
                .then(a => a.json())
                .then(response =>{
                    for(var i = 0 ; i < response.docs.length ; i++){
                        document.getElementById("output").innerHTML+="<h2>"
                                +response.docs[i].title+"</h2>"
                                +response.docs[i].author_name[0]
                                +"<br><img src='http://covers.openlibrary.org/b/isbn/"
                                +response.docs[i].isbn[0]
                                +"-M.jpg'><br>";        }
                });
    }*/

}

