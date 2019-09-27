package com.example.lietenerbox.api;

import com.example.lietenerbox.model.Groups;
import com.example.lietenerbox.model.ItemInGroup;
import com.example.lietenerbox.model.dto.request.ItemsRequestDto;
import com.example.lietenerbox.repository.GroupsRepository;
import com.example.lietenerbox.repository.ItemInGroupRepository;
import com.example.lietenerbox.service.ItemInGroupService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemInGroupApi {

    private final ItemInGroupRepository itemInGroupRepository;
    private final ItemInGroupService itemInGroupService;
    private final GroupsRepository groupsRepository;

    public ItemInGroupApi(ItemInGroupRepository itemInGroupRepository,
                          ItemInGroupService itemInGroupService,
                          GroupsRepository groupsRepository) {
        this.itemInGroupRepository = itemInGroupRepository;
        this.itemInGroupService = itemInGroupService;
        this.groupsRepository = groupsRepository;
    }

    //그룹 내 아이템 생성
    @PostMapping("/items/{groupId}/create")
    public HttpStatus createItems(@RequestBody ItemsRequestDto itemsRequestDto, @PathVariable Long groupId) {

        if (itemsRequestDto == null) {
            return HttpStatus.BAD_REQUEST;
        }

        Groups groups = groupsRepository.findBygroupId(groupId);

        //requestbody값과 그룹의 정보를가지고 그룹에 속한 아이템 생성
        itemInGroupService.createItemInGroup(itemsRequestDto, groups);
        return HttpStatus.OK;
    }

    //그룹내 아이템 리스트 가져오기
    @GetMapping("/items/{groupId}")
    public List<ItemInGroup> ItemInGroupAll(@PathVariable Long groupId) {
        Groups groups = groupsRepository.findBygroupId(groupId);
        return itemInGroupRepository.findAllByGroups(groups);
    }
}
