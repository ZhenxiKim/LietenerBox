package com.example.lietenerbox.repository;

import com.example.lietenerbox.model.Items;
import com.example.lietenerbox.model.Words;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordsRepository extends JpaRepository<Words,Long> {
    //Word findBySetId(Long setId);
    Words findAllByItems(Items items);
    //set아이디로 찾아오니까 repository에 받w는값?
}
