package com.example.lietenerbox.repository;

import com.example.lietenerbox.model.ItemInGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemInGroupRepository extends JpaRepository<ItemInGroup, Long> {

    //사용자 생성 세트
    ItemInGroup findAllBygroupsGroupId(Long groupsGroupId);

}
