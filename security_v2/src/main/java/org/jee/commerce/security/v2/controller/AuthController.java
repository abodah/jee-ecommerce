package org.jee.commerce.security.v2.controller;


import org.jee.commerce.security.v2.config.JWTUtil;
import org.jee.commerce.security.v2.model.CustomerDTO;
import org.jee.commerce.security.v2.model.LoginCredentials;
import org.jee.ecommerce.user.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController // Marks the class a rest controller
@RequestMapping("/api/auth") // Requests made to /api/auth/anything will be handles by this class
public class AuthController {

    // Injecting Dependencies
    private final JWTUtil jwtUtil;
    private final AuthenticationManager authManager;
    private final PasswordEncoder passwordEncoder;
    private final UserAuthenticationService authenticationService;

    public AuthController(JWTUtil jwtUtil, AuthenticationManager authManager, PasswordEncoder passwordEncoder, UserAuthenticationService authenticationService) {
        this.jwtUtil = jwtUtil;
        this.authManager = authManager;
        this.passwordEncoder = passwordEncoder;
        this.authenticationService = authenticationService;
    }

    // Defining the function to handle the POST route for registering a user
    @PostMapping("/register")
    public Map<String, Object> registerHandler(@RequestBody CustomerDTO user){
        // Encoding Password using Bcrypt
        String encodedPass = passwordEncoder.encode(user.getPassword());

        // Setting the encoded password
        user.setPassword(encodedPass);

        // Persisting the User Entity to H2 Database
        // changer cette implementation
        // user = authenticationService.save(user);

        // Generating JWT
        String token = jwtUtil.generateToken(user.getEmail());

        // Responding with JWT
        return Collections.singletonMap("jwt-token", token);
    }

    // Defining the function to handle the POST route for logging in a user
    @PostMapping("/login")
    public Map<String, Object> loginHandler(@RequestBody LoginCredentials body){
        try {
            // Creating the Authentication Token which will contain the credentials for authenticating
            // This token is used as input to the authentication process
            UsernamePasswordAuthenticationToken authInputToken =
                    new UsernamePasswordAuthenticationToken(body.getEmail(), body.getPassword());

            // Authenticating the Login Credentials
            authManager.authenticate(authInputToken);

            // If this point is reached it means Authentication was successful
            // Generate the JWT
            String token = jwtUtil.generateToken(body.getEmail());

            // Respond with the JWT
            return Collections.singletonMap("jwt-token", token);
        }catch (AuthenticationException authExc){
            // Auhentication Failed
            throw new RuntimeException("Invalid Login Credentials");
        }
    }


}