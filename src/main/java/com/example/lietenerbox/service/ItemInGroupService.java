package com.example.lietenerbox.service;

import com.example.lietenerbox.model.Groups;
import com.example.lietenerbox.model.ItemInGroup;
import com.example.lietenerbox.model.Member;
import com.example.lietenerbox.model.dto.request.ItemsRequestDto;
import com.example.lietenerbox.repository.GroupsRepository;
import com.example.lietenerbox.repository.ItemInGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ItemInGroupService {

    private final ItemInGroupRepository itemInGroupRepository;


    public ItemInGroupService(ItemInGroupRepository itemInGroupRepository) {
        this.itemInGroupRepository = itemInGroupRepository;
    }

    @Autowired
    private GroupsRepository groupsRepository;

    public void createItemInGroup(ItemsRequestDto itemsRequestDto, Groups groups) {
        itemInGroupRepository.save(new ItemInGroup(itemsRequestDto, groups));
    }

    public void createItemInGroup(Long groupId, String itemName, Member sessionMember, Groups groups) {
        itemInGroupRepository.save(new ItemInGroup(itemName,sessionMember,groups));
    }
}
