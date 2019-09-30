package com.example.lietenerbox.contoller;

import com.example.lietenerbox.api.exception.DataNotFoundException;
import com.example.lietenerbox.model.Groups;
import com.example.lietenerbox.model.ItemInGroup;
import com.example.lietenerbox.model.Person;
import com.example.lietenerbox.repository.GroupsRepository;
import com.example.lietenerbox.repository.ItemInGroupRepository;
import com.example.lietenerbox.service.ItemInGroupService;
import com.example.lietenerbox.service.WordInGroupService;
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

    @Autowired
    private WordInGroupService wordInGroupService;

    //item 생성
    @PostMapping("/{groupId}/createItem")
    public String createItemInGroup(@PathVariable Long groupId, String itemName, HttpSession session, String wordName, String wordMean) {
        if (!HttpSessionUtils.isLoginPerson(session)) {
            return "/Persons/loginForm";
        }
        Person sessionPerson = HttpSessionUtils.getPersonFromSession(session);

        //아이템이 속한 그룹정보 가져오기
        Groups groups = groupsRepository.findBygroupId(groupId);

        //아이템 생성 후 생성된 아이템 객체 가져오기
        itemInGroupService.createItemInGroup(groupId, itemName, sessionPerson, groups);
        ItemInGroup itemInGroup = itemInGroupService.getItemInGroup(itemName);
        //아이템 객체와 함께 단어 생성하기
        wordInGroupService.createWordInGroup(itemInGroup, wordName, wordMean);
        return "redirect:/items";
    }

    //그룹에 속해진 item 리스트 출력
    @GetMapping("/{groupId}")
    public String itemList(@PathVariable Long groupId, Model model) {
        //그룹에 속한 아이템을 가져오기위해 groupId로 그룹객체 정보 가져오기
        Groups groups = groupsRepository.findById(groupId)
                .orElseThrow(DataNotFoundException::new);

        model.addAttribute("itemInGroup", itemInGroupRepository.findAllByGroups(groups));
        return "/item/itemList";
        // .orElseThrow(() -> new IllegalArgumentException());

    }

    //item 생성 form
    @GetMapping("/{groupId}/itemForm")
    private String itemForm(@PathVariable Long groupId, HttpSession session, Model model) {
        //그룹 생성 시 로그인 유저 확인
        if (!HttpSessionUtils.isLoginPerson(session)) {
            return "/persons/loginForm";
        }

        //현재 로그인 정보 가져오기
        Person sessionPerson = HttpSessionUtils.getPersonFromSession(session);
        Long loginPerson = sessionPerson.getPersonSn();

        model.addAttribute("groups", groupsRepository.findById(groupId));
        //로그인 회원일 경우 아이템 생성 페이지로 이동
        return "/item/itemForm";
    }


    //아이템 생성 후 전체 리스트 페이지로 이동
    @GetMapping("")
    public String itemList(Model model) {

        model.addAttribute("itemInGroup", itemInGroupRepository.findAll());
        return "/item/itemList";
    }
}
