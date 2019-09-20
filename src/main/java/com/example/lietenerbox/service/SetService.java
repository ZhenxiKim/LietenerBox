package com.example.lietenerbox.service;

import com.example.lietenerbox.model.Item;
import com.example.lietenerbox.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
@Transactional
public class SetService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private ItemRepository itemRepository;

    public void createSet(Item item) {
        itemRepository.save(item);
    }
}
