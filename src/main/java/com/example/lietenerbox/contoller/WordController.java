package com.example.lietenerbox.contoller;

import com.example.lietenerbox.contoller.requestDto.ChangeWordsListReqDto;
import com.example.lietenerbox.contoller.requestDto.WordsRequestDto;
import com.example.lietenerbox.contoller.requestDto.WordsListRequestDto;
import com.example.lietenerbox.exception.DataNotFoundException;
import com.example.lietenerbox.model.Folders;
import com.example.lietenerbox.model.Members;
import com.example.lietenerbox.model.Words;
import com.example.lietenerbox.repository.FoldersRepository;
import com.example.lietenerbox.repository.WordsRepository;
import com.example.lietenerbox.service.WordsService;
import com.example.lietenerbox.util.HttpSessionUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "/words",consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_JSON_VALUE})
public class WordController {
    @Autowired
    private WordsRepository wordsRepository;
    @Autowired
    private WordsService wordsService;

    @Autowired
    private FoldersRepository foldersRepository;

    @ApiOperation("폴더의 단어 리스트 생성")
    @PostMapping()
    public ResponseEntity<?> createWordsList(@RequestBody WordsRequestDto reqDto){
        wordsService.createWords(reqDto);
        return ResponseEntity.ok().build();
    }

    @ApiOperation("폴더 소속 단어 리스트 수정")
    @PutMapping()
    public ResponseEntity<?> changeWordsList(@RequestBody ChangeWordsListReqDto reqDto){
        List<Words> Result =  wordsService.changeWordsList(reqDto);
        return ResponseEntity.ok(Result);
    }

    @ApiOperation("폴더 소속 단어 리스트 출력")
    @GetMapping("/{folderSn}")
    public ResponseEntity<?> getWordsList(@PathVariable Long folderSn){

    }




















    @GetMapping("/{itemId}/wordList")
    private String wordsList(@PathVariable Long itemId, HttpSession session, Model model) {
        //그룹 생성 시 로그인 유저 확인
        if (!HttpSessionUtils.isLoginmembers(session)) {
            return "/memberss/loginForm";
        }
        Members sessionMembers = HttpSessionUtils.getmembersFromSession(session);

        Folders folders = foldersRepository.findById(itemId).orElseThrow(DataNotFoundException::new);

        model.addAttribute("words", wordsRepository.findAllByItems(folders));
        return "/words/wordsList";

    }


}
