package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Test {

    @GetMapping ("/test")
    public String greeting (){
        return "Hello World";
    }
    @GetMapping("/secure")
    public String greeting2(){
        return "Hello World from secure end point";
    }
    @GetMapping("/admin/greeting")
    public String greeting3(){
        return "Hello World from admin end point";
    }
    @GetMapping("/user/greeting")
    public String greeting4(){
        return "Hello World from user end point";
    }
}
