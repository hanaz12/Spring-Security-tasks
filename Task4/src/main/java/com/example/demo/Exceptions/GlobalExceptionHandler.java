package com.example.demo.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler (UsernameNotFoundException.class)
    public ResponseEntity<String> UserNotFound(UsernameNotFoundException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Credentials ");
    }
}
