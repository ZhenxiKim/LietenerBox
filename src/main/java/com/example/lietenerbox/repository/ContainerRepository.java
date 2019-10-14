package com.example.lietenerbox.repository;

import com.example.lietenerbox.model.Container;
import com.example.lietenerbox.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContainerRepository extends JpaRepository<Container, Long> {
    //List<Container> findAllByOrderByCreatedAtDesc();

    List<Container> findByPerson(Person person);

    List<Container> findByPersonOrderByCreatedAtDesc(Person person);

    Container findByContainerId(Long containerId);
}
