package com.linda.Library.Security;

import com.linda.Library.Service.UserModelService;
import com.linda.Library.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserFinder {

   @Autowired
    UserModelService userModelService;



    public long getCurrentUserId() {
        UserDetails details = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = details.getUsername();
        long userId = -1;
        for (UserModel userModel : userModelService.findAll());
        {
            if (userModelService.loadUserByUsername(username).equals(username)){
                userId = getCurrentUserId();

            }
        }

        return userId;
    }

    public boolean getCurrentUser(){
        boolean currentUser = userModelService.findAll().equals(getCurrentUserId());
        return currentUser;
    }

}
