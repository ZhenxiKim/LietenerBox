package com.example.lietenerbox.api;

import com.example.lietenerbox.api.exception.DataNotFoundException;
import com.example.lietenerbox.model.Groups;
import com.example.lietenerbox.model.Member;
import com.example.lietenerbox.model.dto.request.GroupsRequestDto;
import com.example.lietenerbox.model.dto.response.GroupsResponseDto;
import com.example.lietenerbox.repository.GroupsRepository;
import com.example.lietenerbox.repository.MemberRepository;
import com.example.lietenerbox.service.GroupsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class GroupsApi {
    //내가 생성한 그룹 리스트 Api

    private final MemberRepository memberRepository;
    private final GroupsRepository groupsRepository;
    private final GroupsService groupsService;


    public GroupsApi(MemberRepository memberRepository,
                     GroupsRepository groupsRepository,
                     GroupsService groupsService) {
        this.memberRepository = memberRepository;
        this.groupsRepository = groupsRepository;
        this.groupsService = groupsService;
    }

    //Group 생성
//    @PostMapping("/groups/{memberSn}/create")
//    public HttpStatus createGroups(@RequestBody GroupsRequestDto requestDto, HttpSession session, @PathVariable Long memberSn) {
//        //현재 로그인 정보
//        Member loginMember = (Member) session.getAttribute("member");
//
//        //로그인한 회원의 정보와 url로 넘어오는 회원의 정보가 같은지 비교
//        if (loginMember.getMemberSn() != memberSn) {
//            return HttpStatus.BAD_REQUEST;
//        }
//
//        groupsService.createGroups(requestDto, loginMember);
//        return HttpStatus.OK;
//    }
//
//
//
//    //회원이 생성한 그룹 전체 리스트 출력
//    @GetMapping("/groups/{memberSn}")
//    private List<Groups> groupsAll(@PathVariable Long memberSn, HttpSession httpSession) {
//        //1. 로그인한 회원 정보 가져오기
//        //2. 로그인한 회원에대한 그룹리스트 가져오기
//
//        //현재 로그인 정보
//        Member loginMember = (Member) httpSession.getAttribute("member");
//
//        //로그인한 회원의 정보와 url로 넘어오는 회원의 정보가 같은지 비교
////        if (loginMember.getMemberSn() != memberSn) {
////            return HttpStatus.BAD_REQUEST;
////        }
//        //멤버객체로 받아야함.
//        groupsService.groupsList(loginMember);
//       // return HttpStatus.OK;
//        return  groupsRepository.findByMemberOrderByCreatedAtDesc(loginMember);
//    }


    //회원이 생성한 그룹 전체 리스트 출력
    @GetMapping("/groups/{memberSn}")
    private ResponseEntity<?> groupsAll(@PathVariable Long memberSn, HttpSession httpSession) {
        //1. 로그인한 회원 정보 가져오기
        //2. 로그인한 회원에대한 그룹리스트 가져오기

        //현재 로그인 정보
        Member loginMember = (Member) httpSession.getAttribute("member");

        Member savedMember = memberRepository.findById(memberSn).orElseThrow(DataNotFoundException::new);

        //로그인한 회원의 정보와 url로 넘어오는 회원의 정보가 같은지 비교
//        if (loginMember.getMemberSn() != memberSn) {
//            return HttpStatus.BAD_REQUEST;
//        }
        //멤버객체로 받아야함.

        // return HttpStatus.OK;
        List<Groups> groupsList = groupsService.groupsList(savedMember);

        return ResponseEntity.ok(groupsList);
    }

    //회원의 정보를 전제로 가져와야하나?
//    @PutMapping("/groups/{groupId}")
//    private HttpStatus updateGroup(@PathVariable Long GroupId,@PathVariable Long memberSn,HttpSession httpSession,@RequestBody GroupsRequestDto requestDto){
//        //현재 로그인 정보
//        Member loginMember = (Member) httpSession.getAttribute("member");
//
//        //로그인한 회원의 정보와 url로 넘어오는 회원의 정보가 같은지 비교
//        if (loginMember.getMemberSn() != memberSn) {
//            return HttpStatus.BAD_REQUEST;
//        }
//        groupsService.updateGroup(requestDto, GroupId);
//        return HttpStatus.OK;
//    }

}
