package com.example.lietenerbox.contoller;

import com.example.lietenerbox.model.ItemInContainer;
import com.example.lietenerbox.model.Members;
import com.example.lietenerbox.repository.ItemInContainerRepository;
import com.example.lietenerbox.repository.WordInContainerRepository;
import com.example.lietenerbox.service.WordInContainerService;
import com.example.lietenerbox.util.HttpSessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

//    @PostMapping("/{itemId}/createWord")
//    public String createWordInGroup(@PathVariable Long itemId, String wordName, String wordMean, HttpSession session, ItemInContainer itemInContainer) {
//
//        //비로그인 멤버는 로그인 페이지로 이동
//        if (!HttpSessionUtils.isLoginmembers(session)) {
//            return "/memberss/loginForm";
//        }
//        members sessionmembers = HttpSessionUtils.getmembersFromSession(session);
//
//        if(itemId != null) {
//            wordInGroupService.createWordInGroup(itemId, wordName, wordMean, sessionmembers, itemInContainer);
//        }
//        return "redirect:/items";
//
//    }

    @GetMapping("/{itemInContainerId}/itemForm")
    private String itemForm(@PathVariable Long itemInContainerId, HttpSession session, Model model) {
        //그룹 생성 시 로그인 유저 확인
        if (!HttpSessionUtils.isLoginmembers(session)) {
            return "/memberss/loginForm";
        }

        //현재 로그인 정보 가져오기
        Members sessionMembers = HttpSessionUtils.getmembersFromSession(session);
        Long loginmembers = sessionMembers.getmembersSn();

        //단어 리스트가 속할 아이템 정보 가져오기
        model.addAttribute("items", itemInContainerRepository.findById(itemInContainerId));
        return "/item/itemForm";
    }

    @GetMapping("/{containerItemId}/itemList")
    private String wordList(@PathVariable Long containerItemId, HttpSession session, Model model) {
        //그룹 생성 시 로그인 유저 확인
        if (!HttpSessionUtils.isLoginmembers(session)) {
            return "/memberss/loginForm";
        }

        //현재 로그인 정보 가져오기
        Members sessionMembers = HttpSessionUtils.getmembersFromSession(session);
        Long loginmembers = sessionMembers.getmembersSn();
        ItemInContainer itemInContainer = itemInContainerRepository.findByContainerItemId(containerItemId);

        //아이템에 속한 단어리스트 가져오기
        model.addAttribute("wordsInContainer", wordInContainerRepository.findByItemInContainer(itemInContainer));
        return "/wordInContainer/wordList";
    }

}
