package com.example.demo.ServiceImpl;

import com.example.demo.DTOs.AuthRequest;
import com.example.demo.Entity.AppUser;
import com.example.demo.Repository.UserRepo;
import com.example.demo.Security.CustomUserDetails;
import com.example.demo.Security.CustomUserDetailsService;
import com.example.demo.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl  implements UserService {
    private final CustomUserDetailsService UserDetailsService;
    private final UserRepo userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public void login(AuthRequest authRequest) {
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword());

        Authentication  authentication=authenticationManager.authenticate(authToken);

        SecurityContextHolder.getContext().setAuthentication(authentication);




    }
}
