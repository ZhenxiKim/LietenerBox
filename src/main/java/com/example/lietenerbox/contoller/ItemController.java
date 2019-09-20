package com.example.lietenerbox.contoller;

import com.example.lietenerbox.model.Item;
import com.example.lietenerbox.repository.MemberRepository;
import com.example.lietenerbox.repository.ItemRepository;
import com.example.lietenerbox.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sets")
public class ItemController {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private WordRepository wordRepository;

    //회원이 만든 세트리스트
    @GetMapping("/{id}")
    public List<Item> setAll(@PathVariable Long memberSn){
        return itemRepository.findAllByMember(memberSn);
    }

//    @GetMapping("/{id}/{
//
//
//
//
//
//    setId}")
//    public Iterable<Word> WordListAll(){
//        return wordRepository.findAll();
//    }
}
