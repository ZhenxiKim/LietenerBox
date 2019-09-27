package com.example.lietenerbox.api;

import com.example.lietenerbox.api.exception.DataNotFoundException;
import com.example.lietenerbox.model.Items;
import com.example.lietenerbox.model.dto.request.WordsRequestDto;
import com.example.lietenerbox.repository.ItemsRepository;
import com.example.lietenerbox.repository.WordsRepository;
import com.example.lietenerbox.service.WordsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WordApi {
    private final WordsRepository wordsRepository;
    private final WordsService wordsService;
    private final ItemsRepository itemsRepository;

    public WordApi(WordsRepository wordsRepository, WordsService wordsService, ItemsRepository itemsRepository) {
        this.wordsRepository = wordsRepository;
        this.wordsService = wordsService;
        this.itemsRepository = itemsRepository;
    }

    //회원의 단어 생성
    @PostMapping("/words/{itemId}")
    public HttpStatus createWords(@RequestBody WordsRequestDto wordsRequestDto, @PathVariable Long itemId) {
        Items items = itemsRepository.findById(itemId).orElseThrow(DataNotFoundException::new);
        wordsService.createWords(wordsRequestDto, items);
        return HttpStatus.OK;
    }

    @GetMapping("/words/{itemId}")
    public ResponseEntity<?> wordsAll(@PathVariable Long itemId) {
        List<Items> wordsList = wordsService.wordsList(itemId);
        return ResponseEntity.ok(wordsList);
    }
}
