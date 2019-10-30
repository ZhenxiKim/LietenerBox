package com.example.lietenerbox;

import com.example.lietenerbox.model.Members;
import feign.RequestLine;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.cloud.openfeign.FeignClient(name="feign",url="http://localhost:8080")
public interface FeignClient {

    @GetMapping("/testfeign")
    String testFeign();

    @RequestLine("GET /members/1")
    Members getMemInfo();
}
