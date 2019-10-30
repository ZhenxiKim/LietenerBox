package com.example.lietenerbox.service;

import com.example.lietenerbox.FeignClient;
import com.example.lietenerbox.contoller.requestDto.MembersCreateRequestDto;
import com.example.lietenerbox.contoller.requestDto.UpdateMemberInfoRequestDto;
import com.example.lietenerbox.exception.DataDuplicatedException;
import com.example.lietenerbox.model.Members;
import com.example.lietenerbox.repository.MembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

@Service
@Transactional
public class MembersService {

    @Autowired
    FeignClient feignClient;



    private final MembersRepository membersRepository;

    public MembersService(MembersRepository membersRepository) {
        this.membersRepository = membersRepository;
    }


    public HttpStatus createMembers(MembersCreateRequestDto requestDto) throws DataDuplicatedException {
        String memId = requestDto.getMembersId();

        // TODO. trycatch 처리
        membersRepository.findByMembersId(requestDto.getMembersId());
/*

                        .ifPresent(v -> !membersRepository.save(new Members(requestDto));
    try {

                } catch (Exception e) {
        e.printStackTrace();
    }*/
        //존재하면 에러, 존재하지 않으면 가입
        return HttpStatus.CONFLICT;


    }

    public Members getMembersInfo(@NotBlank Long membersSn) {
        Members members = membersRepository.findByMembersSn(membersSn);
        return members;
    }

    public void updateMemInfo(UpdateMemberInfoRequestDto updateDto, Long membersSn) {

        Members members = membersRepository.findByMembersSn(membersSn);
        members.setMembersPassword(updateDto.getMemPwd());
        membersRepository.save(members);
    }
}
