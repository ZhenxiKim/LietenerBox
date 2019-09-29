package com.example.lietenerbox.repository;

import com.example.lietenerbox.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByMemberSn(Long memberSn);

    Optional<Member> findByMemberId(String memberId);
    //Member findByMemberId(String memberId);
    //기본조회는 pk값으로 조회
}
