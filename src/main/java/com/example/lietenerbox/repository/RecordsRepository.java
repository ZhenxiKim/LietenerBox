package com.example.lietenerbox.repository;

import com.example.lietenerbox.model.Person;
import com.example.lietenerbox.model.Records;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordsRepository extends JpaRepository<Records,Long> {

    Records findByPersonOrderByCreatedAtDesc(Person loginPerson);
}

