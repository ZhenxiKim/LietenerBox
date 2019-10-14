package com.example.lietenerbox.service;

import com.example.lietenerbox.model.ItemInContainer;
import com.example.lietenerbox.model.WordInContainer;
import com.example.lietenerbox.model.dto.request.WordsInContainerRequestDto;
import com.example.lietenerbox.repository.ItemInContainerRepository;
import com.example.lietenerbox.repository.WordInContainerRepository;
import org.springframework.stereotype.Service;

@Service
public class WordInContainerService {

    private final WordInContainerRepository wordInContainerRepository;
    private final ItemInContainerRepository itemInContainerRepository;

    public WordInContainerService(WordInContainerRepository wordInContainerRepository, ItemInContainerRepository itemInContainerRepository) {
        this.wordInContainerRepository = wordInContainerRepository;
        this.itemInContainerRepository = itemInContainerRepository;
    }

    //api
    public void createWordInContainer(WordsInContainerRequestDto wordsInContainerRequestDto, ItemInContainer itemInContainer) {
        wordInContainerRepository.save(new WordInContainer(wordsInContainerRequestDto, itemInContainer));
    }


    public void createWordInContainer(ItemInContainer itemInContainer, String wordName, String wordMean) {
        wordInContainerRepository.save(new WordInContainer(itemInContainer,wordName,wordMean));
    }
}
