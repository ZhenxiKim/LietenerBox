package com.example.lietenerbox.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/")
    public String home(){
        System.out.println("여기까지");
        return "index";
    }

    @GetMapping("/signup")
    public String signUp(){
        return "signup";
    }
}
