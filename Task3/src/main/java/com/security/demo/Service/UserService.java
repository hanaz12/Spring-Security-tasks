package com.security.demo.Service;

import com.security.demo.Entity.AppUser;
import com.security.demo.Entity.Role;
import com.security.demo.Repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public List<AppUser> findAll() {
        return userRepo.findAll();
    }
    public AppUser findById(Integer id) {
        return userRepo.findById(id).get();
    }
    public AppUser insert ( AppUser user){
        return userRepo.save(user);
    }
}
