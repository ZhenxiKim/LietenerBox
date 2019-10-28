package com.example.lietenerbox.service;

import com.example.lietenerbox.contoller.requestDto.MembersSignInRequestDto;
import com.example.lietenerbox.repository.MembersRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthenticationService {

    private final MembersRepository membersRepository;

    public AuthenticationService(MembersRepository membersRepository) {
        this.membersRepository = membersRepository;

    }

    public void signIn(MembersSignInRequestDto membersSignInRequestDto) {
        //TODO JWT로 구현.....
    }
}
