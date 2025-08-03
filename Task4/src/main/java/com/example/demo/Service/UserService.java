package com.example.demo.Service;

import com.example.demo.DTOs.LoginRequest;
import com.example.demo.DTOs.RegisterRequest;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
    public void login(LoginRequest authRequest);
    public void register(RegisterRequest registerRequest);
}
