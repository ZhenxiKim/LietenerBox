//package com.example.lietenerbox.service;
//
//import com.example.lietenerbox.TestConfiguration;
//import com.example.lietenerbox.model.Items;
//import com.example.lietenerbox.model.members;
//import com.example.lietenerbox.repository.membersRepository;
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
//    private membersRepository membersRepository;
//
//    @Autowired
//    private ItemsRepository itemsRepository;
//
//    @Autowired
//    private SetService setService;
//
//    @Test
//    public void createSet() {
//        members members = new members();
//        members.setmembersId("test");
//
//        members save = membersRepository.save(members);
//
//        Items items = new Items();
//        items.setmembers(save);
//        items.setSetCreatedAt(LocalDateTime.now());
//
//        setService.createSet(items);
//
//        List<Items> all = itemsRepository.findAll();
//
//    }
//
//}
