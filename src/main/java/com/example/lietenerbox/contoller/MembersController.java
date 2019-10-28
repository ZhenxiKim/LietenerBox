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
@RequestMapping(value = "/members", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_JSON_VALUE})
public class MembersController {

    private final MembersRepository membersRepository;
    private final MembersService membersService;

    public MembersController(MembersRepository membersRepository, MembersService membersService) {
        this.membersRepository = membersRepository;
        this.membersService = membersService;
    }

    @ApiOperation(value = "회원아이디 중복확인")
    @ExceptionHandler(DataDuplicatedException.class)
    @GetMapping("/{memId}")
    public ResponseEntity<?> isExist(@PathVariable String memId) {
        try {
            membersService.isExist(memId);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (DataDuplicatedException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }

    @ApiOperation(value = "회원가입")
    @ExceptionHandler(DataDuplicatedException.class)
    @PostMapping("")
    public ResponseEntity<?> createMembers(@RequestBody MembersCreateRequestDto requestDto) throws DataDuplicatedException {

        //TODO try-catch 대안? 오류 질문
//        membersRepository.findByMembersId(requestDto.getMembersId())
//                .ifPresent(v -> {
////                    throw new DataDuplicatedException();
////                });

        Members members = membersService.createMembers(requestDto);
        return ResponseEntity.ok(members);
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
    @PostMapping("/{memberSn")
    public ResponseEntity<?> enrollProfile() {
        return null;
    }
//    @GetMapping("")
//    public String Main(Model model) {
//        model.addAttribute("Items", itemsRepository.findAll());
//        return "/main";
//    }

//    @GetMapping("/loginForm")
//    public String loginForm() {
//        //로그인 요청에 로그인 페이지 리턴
//        return "/members/login";
//    }
//
//    //로그인
//    @PostMapping("/login")
//    public String login(String membersId, String password, HttpSession session) {
//        members members = membersRepository.findBymembersId(membersId)
//                .orElseThrow(DataNotFoundException::new);
//
//        //members members = membersRepository.findBymembersId(membersId);
//        //멤버 null값 체크
//        if (members == null) {
//            //로그인한 회원이 아니라면 로그인 페이지로 이동
//            return "redirect:/memberss/loginForm";
//        }
//
//        //입력한 비밀번호값과 DB에 저장된 비밀번호 비교. matchPassword 메서드는 데이터를 가지고있는 객체에 생성
//        if (!members.matchPassword(password)) {
//            //로그인한 회원이 아니라면 로그인 페이지로 이동
//            return "redirect:/memberss/loginForm";
//        }
//
//        //DB에 저장된 로그인 정보와 동일 시 session 객체에 로그인 정보 저장
//        session.setAttribute("role", members.getRoleCode());
//        session.setAttribute("sessionmembers", members);
//
//        return "redirect:/memberss";
//    }
//
//    //로그아웃 세션에 저장된 로그인 정보 제거
//    @GetMapping("/logout")
//    public String logout(HttpSession session) {
//        session.removeAttribute("sessionmembers");
//        return "redirect:/memberss";
//    }


}
