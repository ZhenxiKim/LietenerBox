package com.example.lietenerbox.api;

import com.example.lietenerbox.model.ItemInContainer;
import com.example.lietenerbox.model.dto.request.WordsInContainerRequestDto;
import com.example.lietenerbox.repository.ItemInContainerRepository;
import com.example.lietenerbox.repository.WordInContainerRepository;
import com.example.lietenerbox.service.WordInContainerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class WordInContainerAPi {

    private final WordInContainerRepository wordInContainerRepository;
    private final WordInContainerService wordInContainerService;
    private final ItemInContainerRepository itemInContainerRepository;

    public WordInContainerAPi(WordInContainerRepository wordInContainerRepository
            , WordInContainerService wordInContainerService
            , ItemInContainerRepository itemInContainerRepository) {
        this.wordInContainerRepository = wordInContainerRepository;
        this.wordInContainerService = wordInContainerService;
        this.itemInContainerRepository = itemInContainerRepository;
    }

    //아이템 내 단어 생성
    @PostMapping("/words/{groupItemId}/create")
    public HttpStatus createWords(@RequestBody WordsInContainerRequestDto wordsInContainerRequestDto, @PathVariable Long groupItemId) {
        if (wordsInContainerRequestDto == null) {
            return HttpStatus.BAD_REQUEST;
        }
        //단어의 리스트가 속할 아이템 객체 정보 찾아오기
        ItemInContainer itemInContainer = itemInContainerRepository.findByContainerItemId(groupItemId);
        wordInContainerService.createWordInContainer(wordsInContainerRequestDto, itemInContainer);
        return HttpStatus.OK;
    }
}
