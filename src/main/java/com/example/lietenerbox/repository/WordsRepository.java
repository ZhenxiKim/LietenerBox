package com.example.lietenerbox.repository;

import com.example.lietenerbox.model.Folders;
import com.example.lietenerbox.model.Words;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WordsRepository extends JpaRepository<Words, Long> {
    //Word findBySetId(Long setId);
    //Words findAllByFolders(Folders folders);
    List<Words> findAllByFolders(Folders folders);

    List<Words> findBywordLevel(int level1);

    //TODO optional 객체로 받는것과 아닌것에 차이가 있나?
    List<Words> findAllByFolders(Optional<Folders> folders);
    //set아이디로 찾아오니까 repository에 받w는값?
}
