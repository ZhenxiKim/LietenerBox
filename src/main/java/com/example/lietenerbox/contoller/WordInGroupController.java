package com.example.lietenerbox.contoller;

import com.example.lietenerbox.model.ItemInGroup;
import com.example.lietenerbox.model.Person;
import com.example.lietenerbox.repository.ItemInGroupRepository;
import com.example.lietenerbox.repository.WordInGroupRepository;
import com.example.lietenerbox.service.WordInGroupService;
import com.example.lietenerbox.util.HttpSessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/words")
public class WordInGroupController {

    @Autowired
    private WordInGroupRepository wordInGroupRepository;

    @Autowired
    private WordInGroupService wordInGroupService;

    @Autowired
    private ItemInGroupRepository itemInGroupRepository;

//    @PostMapping("/{itemId}/createWord")
//    public String createWordInGroup(@PathVariable Long itemId, String wordName, String wordMean, HttpSession session, ItemInGroup itemInGroup) {
//
//        //비로그인 멤버는 로그인 페이지로 이동
//        if (!HttpSessionUtils.isLoginPerson(session)) {
//            return "/Persons/loginForm";
//        }
//        Person sessionPerson = HttpSessionUtils.getPersonFromSession(session);
//
//        if(itemId != null) {
//            wordInGroupService.createWordInGroup(itemId, wordName, wordMean, sessionPerson, itemInGroup);
//        }
//        return "redirect:/items";
//
//    }

    @GetMapping("/{itemInGroupId}/itemForm")
    private String itemForm(@PathVariable Long itemInGroupId, HttpSession session, Model model){
        //그룹 생성 시 로그인 유저 확인
        if (!HttpSessionUtils.isLoginPerson(session)) {
            return "/Persons/loginForm";
        }

        //현재 로그인 정보 가져오기
        Person sessionPerson = HttpSessionUtils.getPersonFromSession(session);
        Long loginPerson = sessionPerson.getPersonSn();

        //단어 리스트가 속할 아이템 정보 가져오기
        model.addAttribute("items",itemInGroupRepository.findById(itemInGroupId));
        return "/item/itemForm";
    }
    @GetMapping("/{itemInGroupId}/itemList")
    private String wordList(@PathVariable Long itemInGroupId, HttpSession session, Model model){
        //그룹 생성 시 로그인 유저 확인
        if (!HttpSessionUtils.isLoginPerson(session)) {
            return "/persons/loginForm";
        }

        //현재 로그인 정보 가져오기
        Person sessionPerson = HttpSessionUtils.getPersonFromSession(session);
        Long loginPerson = sessionPerson.getPersonSn();
        ItemInGroup itemInGroup = itemInGroupRepository.findByGroupItemId(itemInGroupId);

        //아이템에 속한 단어리스트 가져오기
        model.addAttribute("wordsInGroup",wordInGroupRepository.findByItemInGroup(itemInGroup));
        return "/word/wordsList";
    }

}
