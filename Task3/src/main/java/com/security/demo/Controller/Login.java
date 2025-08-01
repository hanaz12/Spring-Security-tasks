package com.security.demo.Controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class Login {
    @GetMapping("/login")
    public String login() {
        System.out.println("login");
        return "loginForm";
    }
    @GetMapping("/after-login")
    public String userHome(Model model, Principal principal) {
       // model.addAttribute("username", principal.getName());
        return "afterLogin";  // اسم الصفحة
    }

}
