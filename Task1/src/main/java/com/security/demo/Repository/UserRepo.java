package com.security.demo.Repository;

import com.security.demo.Entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository <AppUser, Integer> {
Optional<AppUser> findByUsername(String username);
}
