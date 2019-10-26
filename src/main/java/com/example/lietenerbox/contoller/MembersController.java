package com.example.lietenerbox.contoller;

import com.example.lietenerbox.contoller.requestDto.MembersSignupRequestDto;
import com.example.lietenerbox.exception.DataDuplicatedException;
import com.example.lietenerbox.model.Person;
import com.example.lietenerbox.repository.MembersRepository;
import com.example.lietenerbox.service.MembersService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.awt.*;

@RestController
@RequestMapping(value = "/members",consumes={MediaType.APPLICATION_JSON_UTF8_VALUE,MediaType.APPLICATION_JSON_VALUE})
public class MembersController {

    private final MembersRepository membersRepository;
    private final MembersService membersService;

    public MembersController(MembersRepository membersRepository, MembersService membersService) {
        this.membersRepository = membersRepository;
        this.membersService = membersService;
    }


    @ApiOperation(value = "회원가입")
    @PostMapping("/persons")
    public ResponseEntity<?> createPerson(@RequestBody MembersSignupRequestDto requestDto) {

        //기존회원인지 판별
        //TODO try-catch 대안?
        membersRepository.findByPersonId(requestDto.getPersonId())
                .ifPresent(v -> {
                    throw new DataDuplicatedException();
                });

        membersService.signupPerson(requestDto);

        return ResponseEntity.ok(requestDto);
    }

    //회원 전체 리스트 출력
    @ApiOperation(value = "전체회원정보 조회")
    @GetMapping("/persons")
    public List<Person> PersonAll() {

        List<Person> persons = membersRepository.findAll();
        return persons;
    }

    @ApiOperation(value = "특정회원정보 조회")
    @GetMapping("/persons/{personSn}")
    public Person PersonInfo(@PathVariable Long personSn) {
        Person person = membersRepository.findByPersonSn(personSn);
        return person;
    }


    @ApiOperation("회원정보 수정")
    @PutMapping("/persons/{personSn}")
    public HttpStatus update(@PathVariable Long personSn, HttpSession httpSession, @RequestBody PersonUpdateRequestDto updateDto) {

        //현재 로그인 정보
        Person loginPerson = (Person) httpSession.getAttribute("Person");

        //로그인한 회원의 정보와 url로 넘어오는 회원의 정보가 같은지 비교
        if (loginPerson.getPersonSn() != personSn) {
            return HttpStatus.BAD_REQUEST;
        }

        personService.updatePerson(updateDto);
        return HttpStatus.OK;
    }
//    @GetMapping("")
//    public String Main(Model model) {
//        model.addAttribute("Items", itemsRepository.findAll());
//        return "/main";
//    }

//    @GetMapping("/loginForm")
//    public String loginForm() {
//        //로그인 요청에 로그인 페이지 리턴
//        return "/person/login";
//    }
//
//    //로그인
//    @PostMapping("/login")
//    public String login(String personId, String password, HttpSession session) {
//        Person person = personRepository.findByPersonId(personId)
//                .orElseThrow(DataNotFoundException::new);
//
//        //Person Person = PersonRepository.findByPersonId(PersonId);
//        //멤버 null값 체크
//        if (person == null) {
//            //로그인한 회원이 아니라면 로그인 페이지로 이동
//            return "redirect:/persons/loginForm";
//        }
//
//        //입력한 비밀번호값과 DB에 저장된 비밀번호 비교. matchPassword 메서드는 데이터를 가지고있는 객체에 생성
//        if (!person.matchPassword(password)) {
//            //로그인한 회원이 아니라면 로그인 페이지로 이동
//            return "redirect:/persons/loginForm";
//        }
//
//        //DB에 저장된 로그인 정보와 동일 시 session 객체에 로그인 정보 저장
//        session.setAttribute("role", person.getRoleCode());
//        session.setAttribute("sessionPerson", person);
//
//        return "redirect:/persons";
//    }
//
//    //로그아웃 세션에 저장된 로그인 정보 제거
//    @GetMapping("/logout")
//    public String logout(HttpSession session) {
//        session.removeAttribute("sessionPerson");
//        return "redirect:/persons";
//    }


}
