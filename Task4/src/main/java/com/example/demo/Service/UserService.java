package com.example.demo.Service;

import com.example.demo.DTOs.AuthRequest;
import com.example.demo.Entity.AppUser;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
    public void login(AuthRequest authRequest);
}
