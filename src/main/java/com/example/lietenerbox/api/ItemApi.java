package com.example.lietenerbox.api;

import com.example.lietenerbox.api.exception.DataNotFoundException;
import com.example.lietenerbox.model.Items;
import com.example.lietenerbox.model.Member;
import com.example.lietenerbox.model.dto.request.ItemsRequestDto;
import com.example.lietenerbox.repository.GroupsRepository;
import com.example.lietenerbox.repository.ItemsRepository;
import com.example.lietenerbox.repository.MemberRepository;
import com.example.lietenerbox.service.ItemsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemApi {

    private final ItemsRepository itemsRepository;
    private final ItemsService itemsService;
    private final MemberRepository memberRepository;

    public ItemApi(ItemsRepository itemsRepository,
                   ItemsService itemsService,
                   MemberRepository memberRepository) {
        this.itemsRepository = itemsRepository;
        this.itemsService = itemsService;
        this.memberRepository = memberRepository;
    }

    @PostMapping("/items/{memberSn}/create")
    public HttpStatus createItems(@RequestBody ItemsRequestDto itemsRequestDto, HttpSession session, @PathVariable Long memberSn) {
        //현재 로그인 정보
        Member loginMember = (Member) session.getAttribute("member");

        //로그인한 회원의 정보와 url로 넘어오는 회원의 정보가 같은지 비교
        if (loginMember.getMemberSn() != memberSn) {
            return HttpStatus.BAD_REQUEST;
        }
        itemsService.createItems(itemsRequestDto, loginMember);
        return HttpStatus.OK;
    }

    @GetMapping("/items/{memberSn}")
    public ResponseEntity<?> itemsAll(@PathVariable Long memberSn, HttpSession httpSession) {
        //현재 로그인 정보
        Member loginMember = (Member) httpSession.getAttribute("member");
        if(loginMember == null){

        }
        //로그인한 회원정보를 가지고 저장된 회원 정보 가져오기
        Member savedMember = memberRepository.findById(memberSn).orElseThrow(DataNotFoundException::new);

        List<Items> itemsList = itemsService.itemsList(savedMember);

        return ResponseEntity.ok(itemsList);

    }

}
