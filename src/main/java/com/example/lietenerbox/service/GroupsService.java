package com.example.lietenerbox.service;

import com.example.lietenerbox.model.Groups;
import com.example.lietenerbox.model.Person;
import com.example.lietenerbox.model.dto.request.GroupsRequestDto;
import com.example.lietenerbox.repository.GroupsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GroupsService {

    private final GroupsRepository groupsRepository;

    public GroupsService(GroupsRepository groupsRepository) {
        this.groupsRepository = groupsRepository;
    }

    public void createGroup(String groupName, String groupContents, Person sessionPerson) {
        groupsRepository.save(new Groups(groupName, groupContents, sessionPerson));
    }

    //api용 createGroups메서드
    public void createGroups(GroupsRequestDto requestDto, Person sessionPerson) {
        Groups groups = new Groups(requestDto, sessionPerson);
        groupsRepository.save(groups);
    }

    //api read
    public List<Groups> groupsList(Person person) {
        return groupsRepository.findByPersonOrderByCreatedAtDesc(person);
    }

}
