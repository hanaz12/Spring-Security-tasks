package com.example.demo.ServiceImpl;

import com.example.demo.DTOs.LoginRequest;
import com.example.demo.DTOs.RegisterRequest;
import com.example.demo.Entity.AppUser;
import com.example.demo.Entity.Role;
import com.example.demo.Repository.RoleRepo;
import com.example.demo.Repository.UserRepo;
import com.example.demo.Security.CustomUserDetailsService;
import com.example.demo.Service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final CustomUserDetailsService userDetailsService;
    private final UserRepo userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final RoleRepo roleRepository;

    public UserServiceImpl(CustomUserDetailsService userDetailsService,
                           UserRepo userRepository,
                           PasswordEncoder passwordEncoder,
                           AuthenticationManager authenticationManager
    , RoleRepo roleRepo) {
        this.userDetailsService = userDetailsService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.roleRepository = roleRepo;
    }

    @Override
    public void login(LoginRequest authRequest) {
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword());

        Authentication authentication = authenticationManager.authenticate(authToken);

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @Override
    public void register(RegisterRequest registerRequest) {
        if (userRepository.findByUsername(registerRequest.getUsername()).isPresent()) {
            throw new RuntimeException ("User already exists ");
        }
        AppUser user = new AppUser();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

        Role role = new Role();
        role.setName("ROLE_"+registerRequest.getRole().toUpperCase());
        roleRepository.save(role);

        user.getRoles().add(role);
        userRepository.save(user);
    }
}

