package com.example.lietenerbox.contoller;

import com.example.lietenerbox.model.SetInGroup;
import com.example.lietenerbox.repository.SetInGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/group")
public class SetInGroupController {


    private SetInGroupRepository setInGroupRepository;

    @GetMapping("{id}")
    public SetInGroup groupList(@PathVariable Long id){
        return setInGroupRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }
}
