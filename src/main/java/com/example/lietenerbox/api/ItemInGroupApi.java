package com.example.lietenerbox.api;

import com.example.lietenerbox.model.ItemInGroup;
import com.example.lietenerbox.model.Items;
import com.example.lietenerbox.repository.ItemInGroupRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ItemInGroupApi {

//    private ItemInGroupRepository itemInGroupRepository;
//
//    public ItemInGroupApi(ItemInGroupRepository itemInGroupRepository){
//        this.itemInGroupRepository = itemInGroupRepository;
//    }
//
//    @GetMapping("/items/{groupId}")
//    private ItemInGroup ItemInGroupAll(@PathVariable Long groupId){
//        return itemInGroupRepository.findAllBygroupsGroupId(groupId);
//    }
}
