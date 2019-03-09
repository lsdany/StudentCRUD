package com.ld.studentcrud.controllers;

import com.ld.studentcrud.config.JwtTokenUtil;
import com.ld.studentcrud.domain.AuthToken;
import com.ld.studentcrud.domain.User;
import com.ld.studentcrud.domain.UserLogin;
import com.ld.studentcrud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/token")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;

    @PostMapping(value = "/generate-token")
    public AuthToken register(@RequestBody UserLogin userLogin)  {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin.getUsername(), userLogin.getPassword()));
        final User user = userService.findOne(userLogin.getUsername());
        final String token = jwtTokenUtil.generateToken(user);
        return new AuthToken(token, user.getUserName());
    }

    @PostMapping(value = "/user")
    public User createUser(@RequestBody User user){
        return userService.save(user);
    }

}
