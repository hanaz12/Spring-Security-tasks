package com.security.demo.Controller;

import com.security.demo.Service.RoleService;
import com.security.demo.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class Random {
    private final UserService userService;
    private final RoleService roleService;

    @GetMapping("")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(int id) {
        return ResponseEntity.ok(userService.findById(id));
    }

}
