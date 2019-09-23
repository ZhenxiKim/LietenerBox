package com.example.lietenerbox.service;

import com.example.lietenerbox.model.Groups;
import com.example.lietenerbox.model.Member;
import com.example.lietenerbox.repository.GroupsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GroupsService {


    private final GroupsRepository groupsRepository;

    public GroupsService(GroupsRepository groupsRepository) {
        this.groupsRepository = groupsRepository;
    }

//    public Groups groupsList(Long memberSn) {
//        return (Groups) groupsRepository.findAllByMemberSnOrderByCreatedAtDesc(memberSn);
//    }


    public void createGroup(String groupName, String groupContents, Member sessionMember) {
        groupsRepository.save(new Groups(groupName, groupContents, sessionMember));
    }
}
