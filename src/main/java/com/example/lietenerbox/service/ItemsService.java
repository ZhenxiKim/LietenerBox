package com.example.lietenerbox.service;

import com.example.lietenerbox.model.Items;
import com.example.lietenerbox.model.Member;
import com.example.lietenerbox.model.dto.request.ItemsRequestDto;
import com.example.lietenerbox.repository.ItemsRepository;
import com.example.lietenerbox.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsService {
    private final ItemsRepository itemsRepository;
    private final MemberRepository memberRepository;

    public ItemsService(ItemsRepository itemsRepository,MemberRepository memberRepository){
        this.itemsRepository = itemsRepository;
        this.memberRepository = memberRepository;
    }

    //회원 소속 아이템 생성
    public void createItems(ItemsRequestDto itemsRequestDto, Member loginMember) {
        itemsRepository.save(new Items(itemsRequestDto,loginMember));
    }

    //회원이 생성한 아이템 리스트 출력
    public List<Items> itemsList(Member savedMember) {
        return itemsRepository.findAllByMemberOrderByCreatedAtDesc(savedMember);
    }
}
