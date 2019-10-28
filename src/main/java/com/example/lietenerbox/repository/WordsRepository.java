package com.example.lietenerbox.repository;

import com.example.lietenerbox.model.Folders;
import com.example.lietenerbox.model.Words;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordsRepository extends JpaRepository<Words,Long> {
    //Word findBySetId(Long setId);
    //Words findAllByFolders(Folders folders);
    List<Words> findAllByFolders(Folders folders);
    List<Words> findBywordLevel(int level1);
    //set아이디로 찾아오니까 repository에 받w는값?
}
