package com.example.lietenerbox.repository;

import com.example.lietenerbox.contoller.requestDto.WordsListForm;
import com.example.lietenerbox.model.ItemInContainer;
import com.example.lietenerbox.model.WordInContainer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordInContainerRepository extends JpaRepository<WordInContainer,Long> {
    List<WordsListForm> findAllByItemInContainer(ItemInContainer itemInContainer);

    List<WordInContainer> findByContainerWordLevel(int level);
}
