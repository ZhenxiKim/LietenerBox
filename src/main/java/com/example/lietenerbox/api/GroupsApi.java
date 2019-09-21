package com.example.lietenerbox.api;

import com.example.lietenerbox.model.Groups;
import com.example.lietenerbox.repository.GroupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GroupsApi {
    //내가 생성한 그룹 리스트 Api

    private GroupsRepository groupsRepository;

    public GroupsApi(GroupsRepository groupsRepository){
        this.groupsRepository = groupsRepository;
    }

    @GetMapping("/groups")
    private Iterable<Groups> groupsAll(){
        return groupsRepository.findAll();
    }

}
