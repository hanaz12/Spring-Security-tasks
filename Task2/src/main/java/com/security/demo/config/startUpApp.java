package com.security.demo.config;

import com.security.demo.Entity.AppUser;
import com.security.demo.Entity.Role;
import com.security.demo.Service.RoleService;
import com.security.demo.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class startUpApp implements CommandLineRunner {
    private final UserService userService;
    private final RoleService roleService;
    @Override
    public void run(String... args) throws Exception {
 if (roleService.findAll().isEmpty()) {
     roleService.insert(new Role("admin"));
     roleService.insert(new Role("user"));
     roleService.insert(new Role("employee"));
 }
 if (userService.findAll().isEmpty()) {
     Set<Role> adminRoles=new HashSet<>();
     adminRoles.add(roleService.findByName("admin"));

     Set<Role> userRoles=new HashSet<>();
     userRoles.add(roleService.findByName("user"));

     Set<Role> employeeRoles=new HashSet<>();
     employeeRoles.add(roleService.findByName("employee"));
     userService.insert(new AppUser("admin","123","adminFull",adminRoles));
     userService.insert(new AppUser("hanaz","123","hanazFull",adminRoles));
 }
    }
}
