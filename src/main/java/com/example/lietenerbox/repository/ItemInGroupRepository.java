package com.example.lietenerbox.repository;

import com.example.lietenerbox.model.ItemInGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemInGroupRepository extends JpaRepository <ItemInGroup,Long>{
    //GroupSet findByMemberAccount(String memberAccount);
}
