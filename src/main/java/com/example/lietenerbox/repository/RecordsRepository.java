package com.example.lietenerbox.repository;

import com.example.lietenerbox.model.Members;
import com.example.lietenerbox.model.Records;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordsRepository extends JpaRepository<Records, Long> {



    Records findByMembers(Members sessionMembers);
}

