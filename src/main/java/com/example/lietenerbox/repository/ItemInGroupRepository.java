package com.example.lietenerbox.repository;

import com.example.lietenerbox.model.Groups;
import com.example.lietenerbox.model.ItemInGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemInGroupRepository extends JpaRepository<ItemInGroup, Long> {

    //사용자 생성 세트
    List<ItemInGroup> findAllByGroups(Groups groups);
    ItemInGroup findByGroupItemId(Long groupItemId);
    ItemInGroup findByGroups(Groups groups);
    ItemInGroup findBygroupItemName(String groupItemName);

}
