package com.jwt.controller;

import com.jwt.dto.AuthenticationRequest;
import com.jwt.dto.AuthenticationResponse;
import com.jwt.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.jwt.service.UserService;

@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    private final UserService userService;

    public AuthenticationController(AuthenticationManager authenticationManager,
                                    JwtService jwtService,
                                    UserService userService) {

        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @PostMapping
    public AuthenticationResponse authenticate(
            @RequestBody AuthenticationRequest request) {

        authenticationManager.authenticate(

                new UsernamePasswordAuthenticationToken(

                        request.getUsername(),

                        request.getPassword()

                )

        );

        UserDetails userDetails =
                userService.loadUserByUsername(request.getUsername());

        String token =
                jwtService.generateToken(userDetails);

        return new AuthenticationResponse(token);

    }

}