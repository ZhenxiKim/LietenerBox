package com.example.lietenerbox.contoller;

import com.example.lietenerbox.model.Groups;
import com.example.lietenerbox.model.ItemInGroup;
import com.example.lietenerbox.model.Member;
import com.example.lietenerbox.repository.GroupsRepository;
import com.example.lietenerbox.repository.ItemInGroupRepository;
import com.example.lietenerbox.service.ItemInGroupService;
import com.example.lietenerbox.util.HttpSessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/items")
public class ItemInGroupController {

    @Autowired
    private ItemInGroupRepository itemInGroupRepository;

    @Autowired
    private ItemInGroupService itemInGroupService;

    @Autowired
    private GroupsRepository groupsRepository;


    //그룹에 속해진 item 리스트 출력
    @GetMapping("/{groupId}")
    public String itemList(@PathVariable Long groupId, Model model) {
        model.addAttribute("itemInGroup", itemInGroupRepository.findAllByGroupsGroupId();
        return "/index";
        // .orElseThrow(() -> new IllegalArgumentException());

    }

    //item 생성 form
    @GetMapping("/{groupId}/itemForm")
    private String itemForm(@PathVariable Long groupId, HttpSession session,Model model) {
        //그룹 생성 시 로그인 유저 확인
        if (!HttpSessionUtils.isLoginMember(session)) {
            return "/members/loginForm";
        }

       //현재 로그인 정보 가져오기
        Member sessionMember = HttpSessionUtils.getMemberFromSession(session);
        Long loginMember = sessionMember.getMemberSn();

        model.addAttribute("groups", groupsRepository.findById(groupId));
        //로그인 회원일 경우 아이템 생성 페이지로 이동
        return "/item/itemForm";
    }


    //item 생성
    @PostMapping("/{groupId}/createItem")
    public String createItemInGroup(@PathVariable Long groupId, String itemName, HttpSession session, Groups groups) {
        //비로그인 멤버는 로그인 페이지로 이동
        if (!HttpSessionUtils.isLoginMember(session)) {
            return "/members/loginForm";
        }
        Member sessionMember = HttpSessionUtils.getMemberFromSession(session);


        //session객체는 controller까지만
        itemInGroupService.createItemInGroup(groupId, itemName, sessionMember, groups);
        return "redirect:/items";
    }

    //아이템 생성 후 전체 리스트 페이지로 이동
    @GetMapping("")
    public String itemList(Model model) {
        //여기 아이디로 고쳐야함.
        model.addAttribute("itemsInGroups", itemInGroupRepository.findAll());
        return "/index";
    }
}
