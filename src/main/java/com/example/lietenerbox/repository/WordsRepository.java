package com.example.lietenerbox.repository;

import com.example.lietenerbox.model.Words;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordsRepository extends JpaRepository<Words,Long> {
    //Word findBySetId(Long setId);

    //set아이디로 찾아오니까 repository에 받는값?
}
