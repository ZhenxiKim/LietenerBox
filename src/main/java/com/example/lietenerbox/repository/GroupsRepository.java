package com.example.lietenerbox.repository;

import com.example.lietenerbox.model.Groups;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupsRepository extends JpaRepository<Groups,Long> {
    List<Groups> findAllByOrderByCreatedAtDesc();
    List<Groups> findAllByMemberSnOrderByCreatedAtDesc(Long MemberSn);

}
