package com.example.lietenerbox.contoller;

import com.example.lietenerbox.contoller.requestDto.ChangeWordsListReqDto;
import com.example.lietenerbox.contoller.requestDto.WordsRequestDto;
import com.example.lietenerbox.model.Words;
import com.example.lietenerbox.repository.FoldersRepository;
import com.example.lietenerbox.repository.WordsRepository;
import com.example.lietenerbox.service.WordsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/words", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_JSON_VALUE})
public class WordController {
    @Autowired
    private WordsRepository wordsRepository;
    @Autowired
    private WordsService wordsService;

    @Autowired
    private FoldersRepository foldersRepository;

    @ApiOperation("폴더의 단어 리스트 생성")
    @PostMapping()
    public ResponseEntity<?> createWordsList(@RequestBody WordsRequestDto reqDto) {
        wordsService.createWords(reqDto);
        return ResponseEntity.ok().build();
    }

    @ApiOperation("폴더 소속 단어 리스트 수정")
    @PutMapping()
    public ResponseEntity<?> changeWordsList(@RequestBody ChangeWordsListReqDto reqDto) {
        List<Words> result = wordsService.changeWordsList(reqDto);
        return ResponseEntity.ok(result);
    }

    @ApiOperation("폴더 소속 단어 리스트 출력")
    @GetMapping("/{folderSn}")
    public ResponseEntity<?> getWordsList(@PathVariable Long folderSn) {
        List<Words> result = wordsService.getWordsList(folderSn);
        return ResponseEntity.ok(result);
    }


}
