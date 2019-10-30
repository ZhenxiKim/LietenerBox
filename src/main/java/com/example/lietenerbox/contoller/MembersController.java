package com.example.lietenerbox.contoller;

import com.example.lietenerbox.contoller.requestDto.MembersCreateRequestDto;
import com.example.lietenerbox.contoller.requestDto.UpdateMemberInfoRequestDto;
import com.example.lietenerbox.exception.DataDuplicatedException;
import com.example.lietenerbox.model.Members;
import com.example.lietenerbox.repository.MembersRepository;
import com.example.lietenerbox.service.MembersService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

@RestController//TODO mediatype둘다 필요한지 확인필요
@RequestMapping(value = "/members")
public class MembersController {

    private final MembersRepository membersRepository;
    private final MembersService membersService;

    public MembersController(MembersRepository membersRepository, MembersService membersService) {
        this.membersRepository = membersRepository;
        this.membersService = membersService;
    }


    @ApiOperation(value = "회원가입")
    @PostMapping("")
    public ResponseEntity<?> createMembers(@RequestBody MembersCreateRequestDto requestDto) throws DataDuplicatedException {

        //TODO try-catch 대안? 오류 질문
        //membersRepository.findByMembersId(requestDto.getMembersId())
//                .ifPresent(v -> {
//                    throw new DataDuplicatedException();
//                });

        HttpStatus httpStatus = membersService.createMembers(requestDto);
        return ResponseEntity.ok(httpStatus);
    }

    @ApiOperation(value = "특정회원정보 조회")
    @GetMapping("/{membersSn}")
    public ResponseEntity<?> getMembersInfo(@PathVariable @NotBlank Long membersSn) {
        Members memInfo = membersService.getMembersInfo(membersSn);
        return ResponseEntity.ok(memInfo);
    }


    @ApiOperation("회원정보 수정")
    @PatchMapping("/{membersSn}")
    public ResponseEntity<?> updateMemInfo(@PathVariable Long membersSn, @RequestBody UpdateMemberInfoRequestDto updateDto) {
        membersService.updateMemInfo(updateDto, membersSn);
        return ResponseEntity.ok().build();
    }

    @ApiOperation("회원프로필 사진 등록")
    @PostMapping("/{membersSn}")
    public ResponseEntity<?> enrollProfile() {
        //TODO 회원프로필 사진 등록 api
        return null;
    }


}
