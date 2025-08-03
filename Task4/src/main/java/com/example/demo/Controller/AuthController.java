package com.example.demo.Controller;

import com.example.demo.DTOs.LoginRequest;
import com.example.demo.DTOs.RegisterRequest;
import com.example.demo.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class AuthController {
    private final UserService userService;
    public AuthController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/login")
    public ResponseEntity<String > login (@RequestBody LoginRequest authRequest){
userService.login(authRequest);
return ResponseEntity.ok("Login successful");
    }

    @PostMapping("/register")
    public ResponseEntity<String > register (@RequestBody RegisterRequest registerRequest){
        System.out.println("in controller");
        userService.register(registerRequest);
        return ResponseEntity.ok("Register successful");
    }
}
