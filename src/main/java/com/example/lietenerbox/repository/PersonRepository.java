package com.example.lietenerbox.repository;

import com.example.lietenerbox.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByPersonSn(Long PersonSn);

    Optional<Person> findByPersonId(String PersonId);
    //Person findByPersonId(String PersonId);
    //기본조회는 pk값으로 조회
}
