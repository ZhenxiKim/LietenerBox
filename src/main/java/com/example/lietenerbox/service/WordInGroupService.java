package com.example.lietenerbox.service;

import com.example.lietenerbox.model.ItemInGroup;
import com.example.lietenerbox.model.Items;
import com.example.lietenerbox.model.Member;
import com.example.lietenerbox.model.WordInGroup;
import com.example.lietenerbox.model.dto.request.WordsInGroupRequestDto;
import com.example.lietenerbox.repository.ItemInGroupRepository;
import com.example.lietenerbox.repository.WordInGroupRepository;
import org.springframework.stereotype.Service;

@Service
public class WordInGroupService {

    private final WordInGroupRepository wordInGroupRepository;
    private final ItemInGroupRepository itemInGroupRepository;

    public WordInGroupService(WordInGroupRepository wordInGroupRepository, ItemInGroupRepository itemInGroupRepository) {
        this.wordInGroupRepository = wordInGroupRepository;
        this.itemInGroupRepository = itemInGroupRepository;
    }

    //api
    public void createWordInGroup(WordsInGroupRequestDto wordsInGroupRequestDto, ItemInGroup itemInGroup) {
        wordInGroupRepository.save(new WordInGroup(wordsInGroupRequestDto, itemInGroup));
    }


    public void createWordInGroup(ItemInGroup itemInGroup, String wordName, String wordMean) {
        wordInGroupRepository.save(new WordInGroup(itemInGroup,wordName,wordMean));
    }
}
