package com.example.lietenerbox.service;

import com.example.lietenerbox.model.Person;
import com.example.lietenerbox.contoller.requestDto.MembersSignupRequestDto;
import com.example.lietenerbox.contoller.requestDto.MembersUpdateRequestDto;
import com.example.lietenerbox.repository.MembersRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MembersService {

    private final MembersRepository membersRepository;

    public MembersService(MembersRepository membersRepository) {
        this.membersRepository = membersRepository;
    }

    //회원 가입 메서드
    public void signupPerson(MembersSignupRequestDto requestDto) {
        Person person = new Person(requestDto);
        membersRepository.save(person);
    }

    public void updatePerson(MembersUpdateRequestDto updateDto) {
        Person person = new Person(updateDto);
        membersRepository.save(person);
    }


}
