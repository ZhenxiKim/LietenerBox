package com.example.lietenerbox.contoller;

import com.example.lietenerbox.model.ItemInGroup;
import com.example.lietenerbox.repository.ItemInGroupRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/group")
public class SetInGroupController {


    private ItemInGroupRepository itemInGroupRepository;

    @GetMapping("{id}")
    public ItemInGroup groupList(@PathVariable Long id){
        return itemInGroupRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }
}
