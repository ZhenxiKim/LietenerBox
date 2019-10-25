package com.example.lietenerbox.api;

import com.example.lietenerbox.api.exception.DataDuplicatedException;
import com.example.lietenerbox.model.Person;
import com.example.lietenerbox.model.dto.request.PersonSignupRequestDto;
import com.example.lietenerbox.model.dto.request.PersonUpdateRequestDto;
import com.example.lietenerbox.repository.PersonRepository;
import com.example.lietenerbox.service.PersonService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
//회원정보 controller
public class PersonApi {

    private final PersonRepository personRepository;
    private final PersonService personService;

    public PersonApi(PersonRepository personRepository,
                     PersonService personService) {
        this.personRepository = personRepository;
        this.personService = personService;
    }


    //회원 가입 요청
    @ApiOperation(value = "회원가입 요청")
    @PostMapping("/persons")
    public HttpStatus createPerson(@RequestBody PersonSignupRequestDto requestDto) {

        //기존회원인지 판별
        personRepository.findByPersonId(requestDto.getPersonId())
                .ifPresent(v -> {
                    throw new DataDuplicatedException();
                });

        personService.signupPerson(requestDto);

        return HttpStatus.OK;
    }

    //회원 전체 리스트 출력
    @ApiOperation(value = "전체회원정보 조회")
    @GetMapping("/persons")
    public List<Person> PersonAll() {

        List<Person> persons = personRepository.findAll();
        return persons;
    }

    @ApiOperation(value = "특정회원정보 조회")
    @GetMapping("/persons/{personSn}")
    public Person PersonInfo(@PathVariable Long personSn) {
        Person person = personRepository.findByPersonSn(personSn);
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


}
