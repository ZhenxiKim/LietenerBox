package com.example.lietenerbox.api;

import com.example.lietenerbox.model.Groups;
import com.example.lietenerbox.model.Member;
import com.example.lietenerbox.model.dto.GroupsRequestDto;
import com.example.lietenerbox.repository.GroupsRepository;
import com.example.lietenerbox.repository.MemberRepository;
import com.example.lietenerbox.service.GroupsService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
@Validated
public class GroupsApi {
    //내가 생성한 그룹 리스트 Api

    private GroupsRepository groupsRepository;
    private GroupsService groupsService;
    private MemberRepository memberRepository;

    public GroupsApi(GroupsRepository groupsRepository, GroupsService groupsService) {
        this.groupsRepository = groupsRepository;
        this.groupsService = groupsService;
    }

    //회원이 생성한 그룹 전체 리스트 출력
    @GetMapping("/groups/{memberSn}")
    private HttpStatus groupsAll(@PathVariable Long memberSn, HttpSession httpSession) {
        //1. 로그인한 회원 정보 가져오기
        //2. 로그인한 회원에대한 그룹리스트 가져오기

        //현재 로그인 정보
        Member loginMember = (Member) httpSession.getAttribute("member");

        //로그인한 회원의 정보와 url로 넘어오는 회원의 정보가 같은지 비교
//        if (loginMember.getMemberSn() != memberSn) {
//            return HttpStatus.BAD_REQUEST;
//        }
//멤버객체로 받아야함.
        groupsService.groupsList(memberSn);
        return HttpStatus.OK;

    }

}
