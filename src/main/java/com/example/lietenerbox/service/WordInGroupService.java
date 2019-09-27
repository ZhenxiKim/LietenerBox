package com.example.lietenerbox.service;

import com.example.lietenerbox.model.ItemInGroup;
import com.example.lietenerbox.model.WordInGroup;
import com.example.lietenerbox.model.dto.request.WordsRequestDto;
import com.example.lietenerbox.repository.WordInGroupRepository;
import org.springframework.stereotype.Service;

@Service
public class WordInGroupService {

    private final WordInGroupRepository wordInGroupRepository;

    public WordInGroupService(WordInGroupRepository wordInGroupRepository){
        this.wordInGroupRepository = wordInGroupRepository;
    }
    public void createWordInGroup(WordsRequestDto wordsRequestDto, ItemInGroup itemInGroup) {
        wordInGroupRepository.save(new WordInGroup(wordsRequestDto,itemInGroup));

    }
}
