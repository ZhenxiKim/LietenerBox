package com.example.lietenerbox.contoller;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log
public class AdminController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
    

    @RequestMapping("/admin")
    public void forAdmin(){
        log.info("admin");
    }
}
