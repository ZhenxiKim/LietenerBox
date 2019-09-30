package com.example.lietenerbox.repository;

import com.example.lietenerbox.model.Groups;
import com.example.lietenerbox.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupsRepository extends JpaRepository<Groups, Long> {
    //List<Groups> findAllByOrderByCreatedAtDesc();

    List<Groups> findByPerson(Long PersonSn);

    List<Groups> findByPersonOrderByCreatedAtDesc(Person person);

    Groups findBygroupId(Long groupId);
}
