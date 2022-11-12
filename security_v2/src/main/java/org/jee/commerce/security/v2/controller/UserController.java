package org.jee.commerce.security.v2.controller;


import org.jee.ecommerce.user.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController // Marks the class a rest controller
@RequestMapping("/api/user") // Requests made to /api/auth/anything will be handles by this class
public class UserController {

    // Injecting Dependencies
    @Autowired private UserAuthenticationService userAuthenticationService;

    // Defining the function to handle the GET route to fetch user information of the authenticated user
    @GetMapping("/info")
    public UserDetails getUserDetails(){
        // Retrieve email from the Security Context
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // Fetch and return user details
        return userAuthenticationService.loadUserByUsername(email);
    }


}
