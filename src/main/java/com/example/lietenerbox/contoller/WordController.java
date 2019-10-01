package com.example.lietenerbox.contoller;

import com.example.lietenerbox.api.exception.DataNotFoundException;
import com.example.lietenerbox.model.Items;
import com.example.lietenerbox.model.Person;
import com.example.lietenerbox.repository.ItemsRepository;
import com.example.lietenerbox.repository.WordsRepository;
import com.example.lietenerbox.service.WordsService;
import com.example.lietenerbox.util.HttpSessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/words")
public class WordController {
    @Autowired
    private WordsRepository wordsRepository;
    @Autowired
    private WordsService wordsService;

    @Autowired
    private ItemsRepository itemsRepository;


    @GetMapping("/{itemId}/wordList")
    private String wordsList(@PathVariable Long itemId, HttpSession session, Model model) {
        //그룹 생성 시 로그인 유저 확인
        if (!HttpSessionUtils.isLoginPerson(session)) {
            return "/persons/loginForm";
        }
        Person sessionPerson = HttpSessionUtils.getPersonFromSession(session);

        Items items = itemsRepository.findById(itemId).orElseThrow(DataNotFoundException::new);

        model.addAttribute("words", wordsRepository.findAllByItems(items));
        return "/words/wordsList";

    }


}
