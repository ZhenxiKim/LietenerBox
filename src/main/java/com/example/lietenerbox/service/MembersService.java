package com.example.lietenerbox.service;

import com.example.lietenerbox.contoller.requestDto.MembersCreateRequestDto;
import com.example.lietenerbox.contoller.requestDto.UpdateMemberInfoRequestDto;
import com.example.lietenerbox.exception.DataDuplicatedException;
import com.example.lietenerbox.model.Members;
import com.example.lietenerbox.repository.MembersRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotBlank;

@Service
@Transactional
public class MembersService {

    private final MembersRepository membersRepository;

    public MembersService(MembersRepository membersRepository) {
        this.membersRepository = membersRepository;
    }

    public Members isExist(String memId) throws DataDuplicatedException {
        Members members = membersRepository.findByMembersId(memId).orElseThrow(DataDuplicatedException::new);
        return members;
    }

    public Members createMembers(MembersCreateRequestDto requestDto) throws DataDuplicatedException {
        String memId = requestDto.getMembersId();
        Members members = membersRepository.findByMembersId(memId).orElseThrow(DataDuplicatedException::new);
        return membersRepository.save(members);
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
