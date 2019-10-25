package com.example.lietenerbox.service;

import com.example.lietenerbox.model.Person;
import com.example.lietenerbox.model.dto.request.PersonSignupRequestDto;
import com.example.lietenerbox.model.dto.request.PersonUpdateRequestDto;
import com.example.lietenerbox.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    //회원 가입 메서드
    public void signupPerson(PersonSignupRequestDto requestDto) {
        Person person = new Person(requestDto);
        personRepository.save(person);
    }

    public void updatePerson(PersonUpdateRequestDto updateDto) {
        Person person = new Person(updateDto);
        personRepository.save(person);
    }


}
