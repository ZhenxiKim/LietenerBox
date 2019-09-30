package com.example.lietenerbox.repository;

import com.example.lietenerbox.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

<<<<<<< HEAD:src/main/java/com/example/lietenerbox/repository/PersonRepository.java
public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByPersonSn(Long PersonSn);

    Optional<Person> findByPersonId(String PersonId);
    //Person findByPersonId(String PersonId);
=======
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByMemberSn(Long memberSn);

    Optional<Member> findByMemberId(String memberId);
    //Member findByMemberId(String memberId);
>>>>>>> parent of 8c5201d... Member엔티티명 Person으로 변경:src/main/java/com/example/lietenerbox/repository/MemberRepository.java
    //기본조회는 pk값으로 조회
}
