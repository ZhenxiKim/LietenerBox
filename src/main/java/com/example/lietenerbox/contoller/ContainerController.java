package com.example.lietenerbox.contoller;

import com.example.lietenerbox.model.Container;
import com.example.lietenerbox.model.Members;
import com.example.lietenerbox.repository.ContainerRepository;
import com.example.lietenerbox.service.ContainerService;
import com.example.lietenerbox.util.HttpSessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/container")
public class ContainerController {
    //회원만 볼 수 있는 회원 그룹

    @Autowired
    private ContainerRepository containerRepository;

    @Autowired
    private ContainerService containerService;

    //그룹 생성
    @PostMapping("")
    public String createcontainer(String containerName, String containerContents, HttpSession session) {

        //비로그인 멤버는 로그인 페이지로 이동
        if (!HttpSessionUtils.isLoginmembers(session)) {
            return "/memberss/loginForm";
        }
        Members sessionMembers = HttpSessionUtils.getmembersFromSession(session);

        //session 객체는 controller까지만
        containerService.createContainer(containerName, containerContents, sessionMembers);
        return "redirect:/container";
    }

    @GetMapping("/Form")
    private String containerForm(HttpSession session) {

        //그룹 생성 시 로그인 유저 확인
        if (!HttpSessionUtils.isLoginmembers(session)) {
            return "/memberss/loginForm";
        }
        //로그인 회원일 경우 그룹 생성 페이지로 이동
        return "/container/containerForm";

    }

    //그룹 생성 후 전체 리스트 페이지로 이동
//    @GetMapping("")
//    public String containerList(Model model, HttpSession session) {
//        //model.addAttribute("container", containerRepository.findAllByOrderByCreatedAtDesc());
//
//        //현재 로그인 정보 가져오기
//        Members sessionMembers = HttpSessionUtils.getmembersFromSession(session);
//        Long loginmembers = sessionMembers.getmembersSn();
//
//        List<Container> containers = containerRepository.findBymembersOrderByCreatedAtDesc(sessionMembers);
//        //현재 로그인한 회원이 생성한 그룹만 가져오기
//
//
//        model.addAttribute("container", containers);
//        return "/container/containerList";
//
//
//    }

}
