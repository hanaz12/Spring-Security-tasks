package com.security.demo.Service;

import com.security.demo.Entity.Role;
import com.security.demo.Repository.RoleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepo roleRepo;

   public List<Role> findAll() {
        return roleRepo.findAll();
    }
    public Role findById(int id) {
        return roleRepo.findById(id).orElse(null);
    }
    public Role insert(Role role) {
        return roleRepo.save(role);
    }
    public Role findByName(String name) {
       return roleRepo.findByName(name);
    }
}
