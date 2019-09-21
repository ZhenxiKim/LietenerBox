package com.example.lietenerbox.contoller;

import com.example.lietenerbox.model.ItemInGroup;
import com.example.lietenerbox.repository.ItemInGroupRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/group")
public class ItemInGroupController {


    private ItemInGroupRepository itemInGroupRepository;

    @GetMapping("/{groupId}")
    public ItemInGroup itemList(@PathVariable Long groupId){
        return itemInGroupRepository.findAllBygroupsGroupId(groupId);

        // .orElseThrow(() -> new IllegalArgumentException());
    }
}
