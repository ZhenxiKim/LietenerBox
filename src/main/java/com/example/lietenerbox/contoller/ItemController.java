package com.example.lietenerbox.contoller;

import com.example.lietenerbox.model.Items;
import com.example.lietenerbox.model.Person;
import com.example.lietenerbox.repository.ItemsRepository;
import com.example.lietenerbox.repository.MembersRepository;
import com.example.lietenerbox.repository.WordsRepository;
import com.example.lietenerbox.service.ItemsService;
import com.example.lietenerbox.service.WordsService;
import com.example.lietenerbox.util.HttpSessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/items")
public class ItemController {


    @Autowired
    private ItemsRepository itemsRepository;

    //회원이 생성한 폴더
    @Autowired
    private MembersRepository membersRepository;
    @Autowired
    private ItemsService itemsService;

    @Autowired
    private WordsRepository wordsRepository;
    @Autowired
    private WordsService wordsService;


    @PostMapping("/createItem")
    public String createFolder(String itemName, String wordName,String wordMean, HttpSession session){
        //폴더정보와 폴더에 속한 단어 함께 입력
        //비로그인 멤버는 로그인 페이지로 이동
        if (!HttpSessionUtils.isLoginPerson(session)) {
            return "/persons/loginForm";
        }
        Person sessionPerson = HttpSessionUtils.getPersonFromSession(session);

        //현재 로그인한 회원의 정보 db에서 찾아오기
        Person loginPerson = membersRepository.findByPersonSn(sessionPerson.getPersonSn());
        if(loginPerson == null){
            System.out.println("예외처리");
        }

        //아이템 생성하기
        itemsService.createItems(itemName,loginPerson);
        Items items = itemsService.getItems(itemName);
        wordsService.createWords(wordName,wordMean,items);
        return "redirect:/items";

    }
    @GetMapping("/itemsForm")
    private String itemsForm(HttpSession session){
        //그룹 생성 시 로그인 유저 확인
        if (!HttpSessionUtils.isLoginPerson(session)) {
            return "/persons/loginForm";
        }
        //로그인 회원일 경우 그룹 생성 페이지로 이동
        return "/items/itemsForm";
    }

    @GetMapping("")
    private String itemsList(HttpSession session, Model model){
        //그룹 생성 시 로그인 유저 확인
        if (!HttpSessionUtils.isLoginPerson(session)) {
            return "/persons/loginForm";
        }
        Person sessionPerson = HttpSessionUtils.getPersonFromSession(session);

        //현재 로그인한 회원의 정보 db에서 찾아오기
        Person loginPerson = membersRepository.findByPersonSn(sessionPerson.getPersonSn());

        //회원이 생성한 아이템 찾아오기
        model.addAttribute("items",itemsRepository.findAllByPersonOrderByItemCreatedAtDesc(loginPerson));
        //로그인 회원일 경우 그룹 생성 페이지로 이동
        return "/items/itemsList";
    }
}
