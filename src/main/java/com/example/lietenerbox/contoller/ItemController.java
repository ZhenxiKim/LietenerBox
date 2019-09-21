package com.example.lietenerbox.contoller;

import com.example.lietenerbox.model.Items;
import com.example.lietenerbox.repository.MemberRepository;
import com.example.lietenerbox.repository.ItemsRepository;
import com.example.lietenerbox.repository.WordsRepository;
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
    private ItemsRepository itemsRepository;

    //회원이 만든 세트리스트
//    @GetMapping("/{memberId}")
//    public List<Items> itemList(@PathVariable String memberId) {
//
//        //return Item
//    }


}
