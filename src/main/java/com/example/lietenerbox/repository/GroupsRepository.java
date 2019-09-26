package com.example.lietenerbox.repository;

import com.example.lietenerbox.model.Groups;
import com.example.lietenerbox.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GroupsRepository extends JpaRepository<Groups, Long> {
    //List<Groups> findAllByOrderByCreatedAtDesc();

    List<Groups> findByMember(Long memberSn);

    List<Groups> findByMemberOrderByCreatedAtDesc(Member member);

    <T> Optional<T> findBygroupId(Long groupId);
}
