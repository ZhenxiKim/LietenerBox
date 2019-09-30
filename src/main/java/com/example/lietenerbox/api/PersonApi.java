package com.example.lietenerbox.api;

import com.example.lietenerbox.api.exception.DataDuplicatedException;
import com.example.lietenerbox.model.Person;
import com.example.lietenerbox.model.dto.request.PersonSignupRequestDto;
import com.example.lietenerbox.model.dto.request.PersonUpdateRequestDto;
import com.example.lietenerbox.repository.PersonRepository;
import com.example.lietenerbox.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

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


    //회원 가입
    @PostMapping("/Persons/create")
    public HttpStatus createPerson(@RequestBody PersonSignupRequestDto requestDto) {

        personRepository.findByPersonId(requestDto.getPersonId())
                .ifPresent(v -> {
                    throw new DataDuplicatedException();
                });

        personService.signupPerson(requestDto);

        return HttpStatus.OK;
    }

    //회원 전체 리스트 출력
    @GetMapping("/Persons")
    public Iterable<Person> PersonAll() {
        return personRepository.findAll();
    }

    //회원 id 정보 출력
    @GetMapping("/Persons/{id}")
    public Person PersonInfo(@PathVariable Long id) {

        return personRepository.findByPersonSn(id);
    }

    //회원정보수정
    @PutMapping("/{PersonSn}/update")
    public HttpStatus update(@PathVariable Long PersonSn, Person updateMem, HttpSession httpSession, @RequestBody PersonUpdateRequestDto updateDto) {

        //현재 로그인 정보
        Person loginPerson = (Person) httpSession.getAttribute("Person");

        //로그인한 회원의 정보와 url로 넘어오는 회원의 정보가 같은지 비교
        if (loginPerson.getPersonSn() != PersonSn) {
            return HttpStatus.BAD_REQUEST;
        }

        personService.updatePerson(updateDto);
        return HttpStatus.OK;
    }


}
