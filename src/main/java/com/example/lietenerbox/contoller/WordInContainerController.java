package com.example.lietenerbox.contoller;

import com.example.lietenerbox.contoller.requestDto.WordsInContainerRequestDto;
import com.example.lietenerbox.model.ItemInContainer;
import com.example.lietenerbox.model.Members;
import com.example.lietenerbox.model.dto.response.WordsInItemResDto;
import com.example.lietenerbox.repository.ItemInContainerRepository;
import com.example.lietenerbox.repository.WordInContainerRepository;
import com.example.lietenerbox.service.WordInContainerService;
import com.example.lietenerbox.util.HttpSessionUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/wordsInContainer")
public class WordInContainerController {

    @Autowired
    private WordInContainerRepository wordInContainerRepository;

    @Autowired
    private WordInContainerService wordInContainerService;

    @Autowired
    private ItemInContainerRepository itemInContainerRepository;

    @ApiOperation("클래스 소속 단어 리스트 생성")
    @PostMapping()
    public ResponseEntity<?> createWordsList(@RequestBody WordsInContainerRequestDto reqDto) {
        HttpStatus httpStatus = wordInContainerService.createWordInContainer(reqDto);
        return ResponseEntity.ok(httpStatus);
    }

    @ApiOperation("클래스 소속 단어 리스트 수정")
    @PutMapping()
    public ResponseEntity<?> changeWordsList(@RequestBody WordsInContainerRequestDto reqDto) {
        //TODO 바뀐 내용을 리턴해줘야하나? 아님 페이지에서 다시 요청?
        HttpStatus httpStatus = wordInContainerService.changeWordsInContainer(reqDto);
        return ResponseEntity.ok(httpStatus);

    }

    @ApiOperation("클래스 소속 단어 리스트 출력")
    @GetMapping("/{itemSn}")
    public ResponseEntity<?> getWordsList(@PathVariable Long itemSn) {
        return wordInContainerService.getWordsList(itemSn);
    }
}
