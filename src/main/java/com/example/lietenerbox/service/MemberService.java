package com.example.lietenerbox.service;

<<<<<<< HEAD:src/main/java/com/example/lietenerbox/service/PersonService.java
import com.example.lietenerbox.model.Person;
import com.example.lietenerbox.model.dto.request.PersonSignupRequestDto;
import com.example.lietenerbox.model.dto.request.PersonUpdateRequestDto;
import com.example.lietenerbox.repository.PersonRepository;
=======
import com.example.lietenerbox.model.Member;
import com.example.lietenerbox.model.dto.request.MemberSignupRequestDto;
import com.example.lietenerbox.model.dto.request.MemberUpdateRequestDto;
import com.example.lietenerbox.repository.MemberRepository;
>>>>>>> parent of 8c5201d... Member엔티티명 Person으로 변경:src/main/java/com/example/lietenerbox/service/MemberService.java
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonService {

    private final MemberRepository memberRepository;

<<<<<<< HEAD:src/main/java/com/example/lietenerbox/service/PersonService.java
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
=======
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //회원 가입 메서드
    public void signupMember(MemberSignupRequestDto requestDto) {
        Member member = new Member(requestDto);
        memberRepository.save(member);
    }

    public void updateMember(MemberUpdateRequestDto updateDto) {
        Member member = new Member(updateDto);
        memberRepository.save(member);
>>>>>>> parent of 8c5201d... Member엔티티명 Person으로 변경:src/main/java/com/example/lietenerbox/service/MemberService.java

    }


}
