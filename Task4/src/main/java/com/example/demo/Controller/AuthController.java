package com.example.demo.Controller;

import com.example.demo.DTOs.AuthRequest;
import com.example.demo.Service.UserService;
import com.example.demo.ServiceImpl.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final UserServiceImpl userService;
    @PostMapping("/login")
    public ResponseEntity<String > login (@RequestBody AuthRequest authRequest){
userService.login(authRequest);
return ResponseEntity.ok("Login successful");
    }
}
