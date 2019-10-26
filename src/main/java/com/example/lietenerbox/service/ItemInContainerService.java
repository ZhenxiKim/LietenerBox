package com.example.lietenerbox.service;

import com.example.lietenerbox.model.Container;
import com.example.lietenerbox.model.ItemInContainer;
import com.example.lietenerbox.model.Person;
import com.example.lietenerbox.contoller.requestDto.ItemsInContainerRequestDto;
import com.example.lietenerbox.repository.ContainerRepository;
import com.example.lietenerbox.repository.ItemInContainerRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemInContainerService {

    private final ItemInContainerRepository itemInContainerRepository;
    private final ContainerRepository containerRepository;

    public ItemInContainerService(ItemInContainerRepository itemInContainerRepository, ContainerRepository containerRepository) {
        this.itemInContainerRepository = itemInContainerRepository;
        this.containerRepository = containerRepository;
    }

    //api
    public void createItemInContainer(ItemsInContainerRequestDto itemsInContainerRequestDto, Container container) {
        itemInContainerRepository.save(new ItemInContainer(itemsInContainerRequestDto, container));
    }

    public void createItemInContainer(Long groupId, String itemName, Person sessionPerson, Container container) {
        itemInContainerRepository.save(new ItemInContainer(itemName, sessionPerson, container));
    }

    public ItemInContainer getItemInContainer(String itemName){
        ItemInContainer itemInContainer = itemInContainerRepository.findByContainerItemName(itemName);
        return itemInContainer;
    }
}
