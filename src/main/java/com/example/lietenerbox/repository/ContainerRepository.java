package com.example.lietenerbox.repository;

import com.example.lietenerbox.model.Container;
import com.example.lietenerbox.model.Members;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContainerRepository extends JpaRepository<Container, Long> {
    //List<Container> findAllByOrderByCreatedAtDesc();

    List<Container> findBymembers(Members members);

    List<Container> findBymembersOrderByCreatedAtDesc(Members members);

    Container findByContainerId(Long containerId);
}
