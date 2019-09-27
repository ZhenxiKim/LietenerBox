package com.example.lietenerbox.api;

import com.example.lietenerbox.model.ItemInGroup;
import com.example.lietenerbox.model.dto.request.WordsInGroupRequestDto;
import com.example.lietenerbox.repository.ItemInGroupRepository;
import com.example.lietenerbox.repository.WordInGroupRepository;
import com.example.lietenerbox.service.WordInGroupService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class WordInGroupAPi {

    private final WordInGroupRepository wordInGroupRepository;
    private final WordInGroupService wordInGroupService;
    private final ItemInGroupRepository itemInGroupRepository;

    public WordInGroupAPi(WordInGroupRepository wordInGroupRepository
            , WordInGroupService wordInGroupService
            , ItemInGroupRepository itemInGroupRepository) {
        this.wordInGroupRepository = wordInGroupRepository;
        this.wordInGroupService = wordInGroupService;
        this.itemInGroupRepository = itemInGroupRepository;
    }

    //아이템 내 단어 생성
    @PostMapping("/words/{groupItemId}/create")
    public HttpStatus createWords(@RequestBody WordsInGroupRequestDto wordsInGroupRequestDto, @PathVariable Long groupItemId) {
        if (wordsInGroupRequestDto == null) {
            return HttpStatus.BAD_REQUEST;
        }
        //단어의 리스트가 속할 아이템 객체 정보 찾아오기
        ItemInGroup itemInGroup = itemInGroupRepository.findByGroupItemId(groupItemId);
        WordInGroupService.createWordInGroup(wordsInGroupRequestDto,itemInGroup);
        return HttpStatus.OK;
    }
}
