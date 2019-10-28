package com.example.lietenerbox.repository;

import com.example.lietenerbox.model.Members;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MembersRepository extends JpaRepository<Members, Long> {
    Members findByMembersSn(Long membersSn);

    Optional<Members> findByMembersId(String memId);
    //members findBymembersId(String membersId);
    //기본조회는 pk값으로 조회
}
