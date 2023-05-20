package com.hualpusher.portfolio.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hualpusher.portfolio.dto.Login;


@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "https://portfolio-ramiro-hualpa.web.app/login")
public class LoginController {
    @Value("${app.admin.username}")
    private String adminUsername;

    @Value("${app.admin.password}")
    private String adminPassword;
    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody Login login) {
        boolean usernameMatches = adminUsername.equals(login.getUsername());
        boolean passwordMatches = adminPassword.equals(login.getPassword());

        if (!usernameMatches || !passwordMatches) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        return ResponseEntity.ok().build();
    }
}
