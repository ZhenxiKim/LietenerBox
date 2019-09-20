package com.example.lietenerbox.repository;

import com.example.lietenerbox.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepository extends JpaRepository<Word,Long> {
    //Word findBySetId(Long setId);

    //set아이디로 찾아오니까 repository에 받는값?
}
