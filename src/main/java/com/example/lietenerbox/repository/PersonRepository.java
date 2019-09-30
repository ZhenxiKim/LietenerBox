package com.example.lietenerbox.repository;

import com.example.lietenerbox.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Person, Long> {
    Person findByMemberSn(Long memberSn);

    Optional<Person> findByMemberId(String memberId);
    //Member findByMemberId(String memberId);
    //기본조회는 pk값으로 조회
}
