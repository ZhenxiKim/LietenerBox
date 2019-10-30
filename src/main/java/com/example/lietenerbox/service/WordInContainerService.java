package com.example.lietenerbox.service;

import com.example.lietenerbox.contoller.requestDto.WordsListForm;
import com.example.lietenerbox.exception.DataNotFoundException;
import com.example.lietenerbox.model.ItemInContainer;
import com.example.lietenerbox.model.WordInContainer;
import com.example.lietenerbox.contoller.requestDto.WordsInContainerRequestDto;
import com.example.lietenerbox.model.Words;
import com.example.lietenerbox.model.dto.response.WordsInItemResDto;
import com.example.lietenerbox.repository.ItemInContainerRepository;
import com.example.lietenerbox.repository.WordInContainerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordInContainerService {

    private final WordInContainerRepository wordInContainerRepository;
    private final ItemInContainerRepository itemInContainerRepository;

    public WordInContainerService(WordInContainerRepository wordInContainerRepository, ItemInContainerRepository itemInContainerRepository) {
        this.wordInContainerRepository = wordInContainerRepository;
        this.itemInContainerRepository = itemInContainerRepository;
    }

    public HttpStatus createWordInContainer(WordsInContainerRequestDto reqDto) {

        Long itemSn = reqDto.getItemSn();//단어리스트 소속 아이템 세트 시리얼넘버버
        ItemInContainer itemInContainer = itemInContainerRepository.findById(itemSn).orElseThrow(DataNotFoundException::new);
        List<WordsListForm> wordsList = reqDto.getListWords();

        for (WordsListForm word : wordsList) {

            String wordName = word.getWordName();
            String wordMean = word.getWordMean();
            String wordPhoto = word.getPhotoName();
            String wordLoc = word.getPhotoLoc();


            wordInContainerRepository.save(new WordInContainer(itemInContainer, wordName, wordMean, wordPhoto, wordLoc));
        }
        return HttpStatus.OK;
    }


    public HttpStatus changeWordsInContainer(WordsInContainerRequestDto reqDto) {
        Long itemSn = reqDto.getItemSn();//단어리스트 소속 아이템 세트 시리얼넘버
        ItemInContainer itemInContainer = itemInContainerRepository.findById(itemSn).orElseThrow(DataNotFoundException::new);
        List<WordsListForm> wordsList = reqDto.getListWords();

        for (WordsListForm word : wordsList) {

            String wordName = word.getWordName();
            String wordMean = word.getWordMean();
            String wordPhoto = word.getPhotoName();
            String wordLoc = word.getPhotoLoc();


            wordInContainerRepository.save(new WordInContainer(itemInContainer, wordName, wordMean, wordPhoto, wordLoc));
        }

        return HttpStatus.OK;
    }

    public ResponseEntity<?> getWordsList(Long itemSn) {
        ItemInContainer itemInContainer = itemInContainerRepository.findById(itemSn).orElseThrow(DataNotFoundException::new);
        List<WordsListForm> wordsList = wordInContainerRepository.findAllByItemInContainer(itemInContainer);
        WordsInItemResDto resDto = new WordsInItemResDto();
        resDto.setItemSn(itemSn);
        resDto.setWordsList(wordsList);
        return ResponseEntity.ok(resDto);
    }
}
