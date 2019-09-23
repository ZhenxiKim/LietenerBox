package com.example.lietenerbox.service;

import com.example.lietenerbox.model.Groups;
import com.example.lietenerbox.model.ItemInGroup;
import com.example.lietenerbox.model.Member;
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


    public void createItemInGroup(Long groupId, String itemName, Member sessionMember, Groups groups) {

//        if(groups.getMember().getMemberSn() != sessionMember.getMemberSn()){
//            //오류처리리
//       }


        if (groupsRepository.findById(groupId) != null) {
            //생성된 그룹이 없음
        }
        Groups itemIngroup = groupsRepository.getOne(groupId);
        itemInGroupRepository.save(new ItemInGroup(itemName, sessionMember, itemIngroup));
    }
}
