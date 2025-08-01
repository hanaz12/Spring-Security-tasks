package com.security.demo.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Sec_Users")

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String password;
    private String fullName;
    @ManyToMany
    @JoinTable(name="sec_user_roles",
            joinColumns = @JoinColumn (name="user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id")
    )
    @OrderColumn(name="id")

    private Set<Role> roles=new HashSet<>();

    public AppUser(String admin, String number, String adminFull, Set<Role> adminRoles) {
   this.username = admin;
   this.password = number;
   this.fullName = adminFull;
   this.roles = adminRoles;
    }
}
