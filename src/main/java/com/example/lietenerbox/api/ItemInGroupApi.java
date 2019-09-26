package com.example.lietenerbox.api;

import com.example.lietenerbox.api.exception.DataDuplicatedException;
import com.example.lietenerbox.api.exception.DataNotFoundException;
import com.example.lietenerbox.model.Groups;
import com.example.lietenerbox.model.ItemInGroup;
import com.example.lietenerbox.model.Items;
import com.example.lietenerbox.model.Member;
import com.example.lietenerbox.model.dto.request.ItemsRequestDto;
import com.example.lietenerbox.repository.GroupsRepository;
import com.example.lietenerbox.repository.ItemInGroupRepository;
import com.example.lietenerbox.repository.ItemsRepository;
import com.example.lietenerbox.service.ItemInGroupService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ItemInGroupApi {

    private final ItemInGroupRepository itemInGroupRepository;
    private final ItemInGroupService itemInGroupService;
    private final GroupsRepository groupsRepository;

    public ItemInGroupApi(ItemInGroupRepository itemInGroupRepository,
                          ItemInGroupService itemInGroupService,
                          GroupsRepository groupsRepository){
        this.itemInGroupRepository = itemInGroupRepository;
        this.itemInGroupService = itemInGroupService;
        this.groupsRepository = groupsRepository;
    }

    //그룹 내 아이템 생성
    @PostMapping("/items/{groupId}/create")
    public HttpStatus createItems(@RequestBody ItemsRequestDto itemsRequestDto, @PathVariable Long groupId ){

        if(itemsRequestDto == null){
            return HttpStatus.BAD_REQUEST;
        }

        Optional<Groups> groups = (Optional<Groups>) groupsRepository.findBygroupId(groupId)
                .orElseThrow(DataNotFoundException::new);

        itemInGroupService.createItemInGroup(itemsRequestDto,groups);
        return HttpStatus.OK;
    }





    @GetMapping("/items/{groupId}")
    public ItemInGroup ItemInGroupAll(@PathVariable Long groupId){
        return itemInGroupRepository.f(groupId);
    }
}
