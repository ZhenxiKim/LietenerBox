package com.example.lietenerbox.contoller;

import com.example.lietenerbox.repository.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sets")
public class ItemController {


    @Autowired
    private ItemsRepository itemsRepository;

    //회원이 만든 세트리스트
//    @GetMapping("/{PersonId}")
//    public List<Items> itemList(@PathVariable String PersonId) {
//
//        //return Item
//    }


}
