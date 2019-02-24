package com.stackroute.controller;


import com.stackroute.message.request.LoginForm;
import com.stackroute.message.response.JwtResponse;
import com.stackroute.repository.UserRepository;
import com.stackroute.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.security.SignatureException;

@CrossOrigin(origins = "*", maxAge = 3600) //allows cross origin to access rest end point
@RestController //specifies this class as rest controller
@RequestMapping("/api/auth") //maps this controller for all /api/auth end point
public class AuthRestAPI {

    @Autowired
    AuthenticationManager authenticationManager;



    @Autowired
    JwtProvider jwtProvider;

    //this method is called when /api/auth/signIn end point is called
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) throws SecurityException , SessionAuthenticationException  {
        //authentication manager verifies username and password received against database
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));


        //context holder saves authentication details for further requests made by client post login
        SecurityContextHolder.getContext().setAuthentication(authentication);

        //jwt token is generated as a response to successful login request
        String jwt = jwtProvider.generateJwtToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        //returning jwt token and respective requested response on successful login
        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername()));
    }

    @GetMapping("/test")
    public String testing(){
        return "working";
    }
}
