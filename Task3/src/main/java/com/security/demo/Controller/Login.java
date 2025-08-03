package com.security.demo.Controller;

import ch.qos.logback.core.model.Model;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class Login {
    @GetMapping("/login")
    public String login() {
        return "loginForm";
    }
    @GetMapping("/after-login")
    public String userHome(Model model, Principal principal) {
       var role= SecurityContextHolder.getContext().getAuthentication().getAuthorities().iterator().next().getAuthority();
       if (role.equals("ROLE_ADMIN")){
           return "adminHomePage";
       }
       else if (role.equals("ROLE_USER")){
           return "userHomePage";
       }
       else return "afterLogin";
    }

}
