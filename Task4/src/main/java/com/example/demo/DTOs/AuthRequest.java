package com.example.demo.DTOs;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AuthRequest {
    private String username;

    private String password;
}
