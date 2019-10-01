package com.example.lietenerbox.service;

import com.example.lietenerbox.model.Items;
import com.example.lietenerbox.model.Person;
import com.example.lietenerbox.model.dto.request.ItemsRequestDto;
import com.example.lietenerbox.repository.ItemsRepository;
import com.example.lietenerbox.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsService {
    private final ItemsRepository itemsRepository;
    private final PersonRepository personRepository;

    public ItemsService(ItemsRepository itemsRepository, PersonRepository personRepository){
        this.itemsRepository = itemsRepository;
        this.personRepository = personRepository;
    }

    //api 회원 소속 아이템 생성
    public void createItems(ItemsRequestDto itemsRequestDto, Person loginPerson) {
        itemsRepository.save(new Items(itemsRequestDto, loginPerson));
    }

    //회원이 생성한 아이템 리스트 출력
    public List<Items> itemsList(Person savedPerson) {
        return itemsRepository.findAllByPersonOrderByItemCreatedAtDesc(savedPerson);
    }

    public void createItems(String itemName,Person loginPerson){
        itemsRepository.save(new Items(itemName,loginPerson));

    }

    public Items getItems(String itemName) {
        return itemsRepository.findByItemName(itemName);
    }
}
