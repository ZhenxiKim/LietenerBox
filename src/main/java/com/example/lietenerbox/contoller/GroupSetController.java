package com.example.lietenerbox.contoller;

import com.example.lietenerbox.model.GroupSet;
import com.example.lietenerbox.repository.GroupSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/group")
public class GroupSetController {

    @Autowired
    private GroupSetRepository groupSetRepository;

    @GetMapping("{id}")
    public GroupSet grouplist(@PathVariable Long id){
        return groupSetRepository.findById(id).get();

    }
}
