package com.example.lietenerbox.service;

import com.example.lietenerbox.model.Groups;
import com.example.lietenerbox.model.Member;
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

    public void createGroup(String groupName, String groupContents, Member sessionMember) {
        groupsRepository.save(new Groups(groupName, groupContents, sessionMember));
    }

    //api용 createGroups메서드
    public void createGroups(GroupsRequestDto requestDto, Member sessionMember) {
        Groups groups = new Groups(requestDto, sessionMember);
        groupsRepository.save(groups);
    }

    //api read
    public List<Groups> groupsList(Member member) {
        return groupsRepository.findByMemberOrderByCreatedAtDesc(member);
    }

    public void updateGroup(Long groupId) {

    }
}
