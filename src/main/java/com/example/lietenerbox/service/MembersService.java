package com.example.lietenerbox.service;

import com.example.lietenerbox.contoller.requestDto.MembersCreateRequestDto;
import com.example.lietenerbox.contoller.requestDto.UpdateMemberInfoRequestDto;
import com.example.lietenerbox.model.Members;
import com.example.lietenerbox.repository.MembersRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Service
@Transactional
public class MembersService {

//    @Autowired
//    FeignClient feignClient;


    private final MembersRepository membersRepository;

    public MembersService(MembersRepository membersRepository) {
        this.membersRepository = membersRepository;
    }


    public Members createMembers(MembersCreateRequestDto requestDto) {

        Members members = Members.builder()
                .membersEmail(requestDto.getMembersEmail())
                .membersId(requestDto.getMembersId())
                .membersInfoAgree(true)
                .membersName(requestDto.getMembersName())
                .membersPassword(requestDto.getMembersPassword())
                .membersRegisterDate(LocalDateTime.now())
                .build();


        //TODO http에 모든것은 api단까지

        return membersRepository.save(members);

    }

    public Members getMembersInfo(@NotBlank Long membersSn) {

        Members members = membersRepository.findByMembersSn(1L);
        System.out.println(members);
        return members;
    }

    public void updateMemInfo(UpdateMemberInfoRequestDto updateDto, Long membersSn) {

        Members members = membersRepository.findByMembersSn(membersSn);
        members.setMembersPassword(updateDto.getMemPwd());
        membersRepository.save(members);
    }

    public boolean isExistMember(String memId) {
        return membersRepository.existsByMembersId(memId);
    }
}
