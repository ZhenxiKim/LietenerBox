package com.example.lietenerbox.service;

import com.example.lietenerbox.model.Items;
import com.example.lietenerbox.model.Words;
import com.example.lietenerbox.contoller.requestDto.WordsRequestDto;
import com.example.lietenerbox.repository.ItemsRepository;
import com.example.lietenerbox.repository.WordsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordsService {
    private final WordsRepository wordsRepository;
    private final ItemsRepository itemsRepository;

    public WordsService(WordsRepository wordsRepository,
                           ItemsRepository itemsRepository){
        this.wordsRepository = wordsRepository;
        this.itemsRepository = itemsRepository;
    }

    public void createWords(WordsRequestDto wordsRequestDto, Items items) {
        wordsRepository.save(new Words(wordsRequestDto,items));
    }

    public List<Items> wordsList(Long itemId) {
        return itemsRepository.findAll();
    }

    public void createWords(String wordName, String wordMean, Items items) {
        wordsRepository.save(new Words(wordName,wordMean,items));
    }
}
