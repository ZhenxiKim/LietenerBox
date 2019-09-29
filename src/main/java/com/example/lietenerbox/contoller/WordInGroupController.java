package com.example.lietenerbox.contoller;

import com.example.lietenerbox.model.ItemInGroup;
import com.example.lietenerbox.model.Items;
import com.example.lietenerbox.model.Member;
import com.example.lietenerbox.repository.ItemInGroupRepository;
import com.example.lietenerbox.repository.WordInGroupRepository;
import com.example.lietenerbox.service.WordInGroupService;
import com.example.lietenerbox.util.HttpSessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
//        if (!HttpSessionUtils.isLoginMember(session)) {
//            return "/members/loginForm";
//        }
//        Member sessionMember = HttpSessionUtils.getMemberFromSession(session);
//
//        if(itemId != null) {
//            wordInGroupService.createWordInGroup(itemId, wordName, wordMean, sessionMember, itemInGroup);
//        }
//        return "redirect:/items";
//
//    }

    @GetMapping("/{itemId}/itemForm")
    private String itemForm(@PathVariable Long itemId, HttpSession session, Model model){
        //그룹 생성 시 로그인 유저 확인
        if (!HttpSessionUtils.isLoginMember(session)) {
            return "/members/loginForm";
        }

        //현재 로그인 정보 가져오기
        Member sessionMember = HttpSessionUtils.getMemberFromSession(session);
        Long loginMember = sessionMember.getMemberSn();

        //단어 리스트가 속할 아이템 정보 가져오기
        model.addAttribute("items",itemInGroupRepository.findById(itemId));
        return "/item/itemForm";
    }


}
