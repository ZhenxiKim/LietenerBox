package com.example.lietenerbox.contoller;

import com.example.lietenerbox.api.exception.DataNotFoundException;
import com.example.lietenerbox.model.Person;
import com.example.lietenerbox.repository.ItemsRepository;
import com.example.lietenerbox.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ItemsRepository itemsRepository;

    @GetMapping("")//로그인 성공 시 단어 및 아이템 목록 페이지로 이동
    public String Main(Model model) {
        model.addAttribute("Items", itemsRepository.findAll());
        return "/main";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        //로그인 요청에 로그인 페이지 리턴
        return "/person/login";
    }

    //로그인
    @PostMapping("/login")
    public String login(String personId, String password, HttpSession session) {
        Person person = personRepository.findByPersonId(personId)
                .orElseThrow(DataNotFoundException::new);

        //Person Person = PersonRepository.findByPersonId(PersonId);
        //멤버 null값 체크
        if (person == null) {
            //로그인한 회원이 아니라면 로그인 페이지로 이동
            return "redirect:/persons/loginForm";
        }

        //입력한 비밀번호값과 DB에 저장된 비밀번호 비교. matchPassword 메서드는 데이터를 가지고있는 객체에 생성
        if (!person.matchPassword(password)) {
            //로그인한 회원이 아니라면 로그인 페이지로 이동
            return "redirect:/persons/loginForm";
        }

        //DB에 저장된 로그인 정보와 동일 시 session 객체에 로그인 정보 저장
        session.setAttribute("role", person.getRoleCode());
        session.setAttribute("sessionPerson", person);

        return "redirect:/persons";
    }

    //로그아웃 세션에 저장된 로그인 정보 제거
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("sessionPerson");
        return "redirect:/persons";
    }


}
