package com.example.lietenerbox.service;

import com.example.lietenerbox.model.Person;
import com.example.lietenerbox.model.dto.request.MemberSignupRequestDto;
import com.example.lietenerbox.model.dto.request.MemberUpdateRequestDto;
import com.example.lietenerbox.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberService {

    private final PersonRepository personRepository;

    public MemberService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    //회원 가입 메서드
    public void signupMember(MemberSignupRequestDto requestDto) {
        Person person = new Person(requestDto);
        personRepository.save(person);
    }

    public void updateMember(MemberUpdateRequestDto updateDto) {
        Person person = new Person(updateDto);
        personRepository.save(person);

    }


}
