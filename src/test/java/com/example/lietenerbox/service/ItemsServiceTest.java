//package com.example.lietenerbox.service;
//
//import com.example.lietenerbox.TestConfiguration;
//import com.example.lietenerbox.model.Items;
//import com.example.lietenerbox.model.member;
//import com.example.lietenerbox.repository.MemberRepository;
//import com.example.lietenerbox.repository.ItemsRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = TestConfiguration.class)
//public class ItemsServiceTest {
//
//    @Autowired
//    private MemberRepository memberRepository;
//
//    @Autowired
//    private ItemsRepository itemsRepository;
//
//    @Autowired
//    private SetService setService;
//
//    @Test
//    public void createSet() {
//        member member = new member();
//        member.setMemberId("test");
//
//        member save = memberRepository.save(member);
//
//        Items items = new Items();
//        items.setMember(save);
//        items.setSetCreatedAt(LocalDateTime.now());
//
//        setService.createSet(items);
//
//        List<Items> all = itemsRepository.findAll();
//
//    }
//
//}
