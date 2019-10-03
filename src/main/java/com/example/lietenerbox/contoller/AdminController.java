package com.example.lietenerbox.contoller;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log
public class AdminController {

    @GetMapping("/")
    public String index() {
        return "index";
    }


    @GetMapping("/admin")
    public String forAdmin() {

        log.info("admin");
        return "/admin";
    }
}
