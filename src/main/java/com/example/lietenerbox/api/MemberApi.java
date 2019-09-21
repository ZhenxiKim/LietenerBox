package com.example.lietenerbox.api;

import com.example.lietenerbox.model.Member;
import com.example.lietenerbox.repository.MemberRepository;
import com.example.lietenerbox.service.MemberService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
//회원정보 controller
public class MemberApi {

    private final MemberRepository memberRepository;

    public MemberApi(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*어떤 방식이 맞는지?
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }*/

    //회원 전체 리스트
    @GetMapping("/members")
    public Iterable<Member> memberAll(){
        return  memberRepository.findAll();
    }

    //회원 id 정보
    @GetMapping("/members/{id}")
    public Member memberInfo(@PathVariable Long id){

        return memberRepository.findByMemberSn(id);
    }

    //회원정보수정
    @PutMapping("/{id}")
    public String update(@PathVariable Long id, Member updateMem, HttpSession httpSession){
        //로그인 유저 검사
        return null;
    }

}
