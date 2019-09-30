package com.example.lietenerbox.contoller;

import com.example.lietenerbox.model.Groups;
import com.example.lietenerbox.model.Person;
import com.example.lietenerbox.repository.GroupsRepository;
import com.example.lietenerbox.service.GroupsService;
import com.example.lietenerbox.util.HttpSessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;


@Controller
@RequestMapping("/groups")
public class GroupsController {
    //회원만 볼 수 있는 회원 그룹

    @Autowired
    private GroupsRepository groupsRepository;

    @Autowired
    private GroupsService groupsService;

    //그룹 생성
    @PostMapping("")
    public String createGroup(String groupName, String groupContents, HttpSession session) {

        //비로그인 멤버는 로그인 페이지로 이동
        if (!HttpSessionUtils.isLoginPerson(session)) {
            return "/persons/loginForm";
        }
        Person sessionPerson = HttpSessionUtils.getPersonFromSession(session);

        //session 객체는 controller까지만
        groupsService.createGroup(groupName, groupContents, sessionPerson);
        return "redirect:/groups";
    }

    @GetMapping("/groupForm")
    private String groupForm(HttpSession session) {

        //그룹 생성 시 로그인 유저 확인
        if (!HttpSessionUtils.isLoginPerson(session)) {
            return "/persons/loginForm";
        }
        //로그인 회원일 경우 그룹 생성 페이지로 이동
        return "/groups/groupForm";

    }

    //그룹 생성 후 전체 리스트 페이지로 이동
    @GetMapping("")
    public String groupList(Model model, HttpSession session) {
        //model.addAttribute("groups", groupsRepository.findAllByOrderByCreatedAtDesc());

        //현재 로그인 정보 가져오기
        Person sessionPerson = HttpSessionUtils.getPersonFromSession(session);
        Long loginPerson = sessionPerson.getPersonSn();

        List<Groups> groups = groupsRepository.findByPersonOrderByCreatedAtDesc(sessionPerson);
        //현재 로그인한 회원이 생성한 그룹만 가져오기


        model.addAttribute("groups", groups);
        return "/index";


    }

}
