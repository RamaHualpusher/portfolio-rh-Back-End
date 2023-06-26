package com.hualpusher.portfolio.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hualpusher.portfolio.dto.Login;


@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class LoginController {
    @Value("${spring.security.user.name}")
    private String username;

    @Value("${spring.security.user.password}")
    private String password;
    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody Login login) {
        boolean usernameMatches = username.equals(login.getUsername());
        boolean passwordMatches = password.equals(login.getPassword());

        if (!usernameMatches || !passwordMatches) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        return ResponseEntity.ok().build();
    }

}
