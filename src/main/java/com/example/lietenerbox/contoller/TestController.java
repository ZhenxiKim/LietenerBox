package com.example.lietenerbox.contoller;

import com.example.lietenerbox.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final TestService testService;

    public TestController(TestService testService){
        this.testService = testService;
    }

    @GetMapping("/")
    public String feignMain(){
        return testService.testFeign();
    }

    @GetMapping("/testfeign")
    public String testFeign() {
        return "Hello Feign Cleint~ 찡긋";
    }
}
