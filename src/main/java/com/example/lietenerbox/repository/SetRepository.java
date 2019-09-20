package com.example.lietenerbox.repository;

import com.example.lietenerbox.model.Set;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SetRepository extends JpaRepository<Set,Long> {
    //Set findAllBymemId(Long memId);
}
