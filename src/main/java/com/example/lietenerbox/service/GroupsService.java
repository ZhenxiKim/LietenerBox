package com.example.lietenerbox.service;

import com.example.lietenerbox.model.Groups;
import com.example.lietenerbox.model.Member;
import com.example.lietenerbox.repository.GroupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.JpaQueryCreator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GroupsService {

    @Autowired
    private GroupsRepository groupsRepository;


    public void createGroup(String groupName, String groupContents, Member sessionMember) {
        groupsRepository.save(new Groups(groupName, groupContents, sessionMember));
    }
}
