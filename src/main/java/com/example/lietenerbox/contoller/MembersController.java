package com.example.lietenerbox.contoller;

import com.example.lietenerbox.contoller.requestDto.MembersCreateRequestDto;
import com.example.lietenerbox.contoller.requestDto.UpdateMemberInfoRequestDto;
import com.example.lietenerbox.exception.DataDuplicatedException;
import com.example.lietenerbox.model.Members;
import com.example.lietenerbox.repository.MembersRepository;
import com.example.lietenerbox.service.MembersService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

@RestController//TODO mediatype둘다 필요한지 확인필요

public class MembersController {

    private final MembersRepository membersRepository;
    private final MembersService membersService;

    public MembersController(MembersRepository membersRepository, MembersService membersService) {
        this.membersRepository = membersRepository;
        this.membersService = membersService;
    }

    @ApiOperation(value = "회원가입")
    @RequestMapping(method = RequestMethod.POST, value = "/members")
    public ResponseEntity<?> createMembers(@RequestBody MembersCreateRequestDto requestDto) throws DataDuplicatedException {

        return ResponseEntity.ok(membersService.createMembers(requestDto));
    }

    @ApiOperation("회원중복확인")
    @RequestMapping(method = RequestMethod.HEAD, path = "members/{memId}")
    public ResponseEntity<?> isExistMember(@PathVariable String memId) throws Exception {

        if (membersService.isExistMember(memId)) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok().build();
        }

    }

    @ApiOperation(value = "특정회원정보 조회")
    @RequestMapping(method = RequestMethod.GET, value = "/members/{membersSn}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getMembersInfo(@PathVariable @NotBlank Long membersSn) {
        Members memInfo = membersService.getMembersInfo(membersSn);
        return ResponseEntity.ok(memInfo);
    }


//    @ApiOperation("회원정보 수정")
//    @RequestMapping(method=RequestMethod.PATCH,value = "/{membersSn")
//    public ResponseEntity<?> updateMemInfo(@PathVariable Long membersSn, @RequestBody UpdateMemberInfoRequestDto updateDto) {
//        membersService.updateMemInfo(updateDto, membersSn);
//        return ResponseEntity.ok().build();
//    }
//
//    @ApiOperation("회원프로필 사진 등록")
//    @RequestMapping(method = RequestMethod.POST,value = "/{membersSn}")
//
//    public ResponseEntity<?> enrollProfile(@PathVariable Long membersSn) {
//        //TODO 회원프로필 사진 등록 api
//        return null;
//    }


}
