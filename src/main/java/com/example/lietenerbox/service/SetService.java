package com.example.lietenerbox.service;

import com.example.lietenerbox.model.Items;
import com.example.lietenerbox.repository.ItemsRepository;
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
    private ItemsRepository itemsRepository;

    public void createSet(Items items) {
        itemsRepository.save(items);
    }
}
