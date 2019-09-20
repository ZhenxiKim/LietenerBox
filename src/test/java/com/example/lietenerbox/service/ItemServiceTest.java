package com.example.lietenerbox.service;

import com.example.lietenerbox.TestConfiguration;
import com.example.lietenerbox.model.Item;
import com.example.lietenerbox.model.Member;
import com.example.lietenerbox.repository.MemberRepository;
import com.example.lietenerbox.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
public class ItemServiceTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private SetService setService;

    @Test
    public void createSet() {
        Member member = new Member();
        member.setMemberId("test");

        Member save = memberRepository.save(member);

        Item item = new Item();
        item.setMember(save);
        item.setSetCreatedAt(LocalDateTime.now());

        setService.createSet(item);

        List<Item> all = itemRepository.findAll();

    }

}
