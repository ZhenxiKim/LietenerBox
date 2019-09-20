package com.example.lietenerbox.repository;

import com.example.lietenerbox.model.SetInGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SetInGroupRepository extends JpaRepository <SetInGroup,Long>{
    //GroupSet findByMemberAccount(String memberAccount);
}
