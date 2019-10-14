package com.example.lietenerbox.api;

import com.example.lietenerbox.model.Container;
import com.example.lietenerbox.model.ItemInContainer;
import com.example.lietenerbox.model.dto.request.ItemsInContainerRequestDto;
import com.example.lietenerbox.repository.ContainerRepository;
import com.example.lietenerbox.repository.ItemInContainerRepository;
import com.example.lietenerbox.service.ItemInContainerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemInContainerApi {

    private final ItemInContainerRepository itemInContainerRepository;
    private final ItemInContainerService itemInContainerService;
    private final ContainerRepository containerRepository;

    public ItemInContainerApi(ItemInContainerRepository itemInContainerRepository,
                              ItemInContainerService itemInContainerService,
                              ContainerRepository containerRepository) {
        this.itemInContainerRepository = itemInContainerRepository;
        this.itemInContainerService = itemInContainerService;
        this.containerRepository = containerRepository;
    }

    //그룹 내 아이템 생성
    @PostMapping("/items/{containerId}/create")
    public HttpStatus createItems(@RequestBody ItemsInContainerRequestDto itemsInContainerRequestDto, @PathVariable Long containerId) {

        if (itemsInContainerRequestDto == null) {
            return HttpStatus.BAD_REQUEST;
        }

        Container container = containerRepository.findByContainerId(containerId);

        //requestbody값과 그룹의 정보를가지고 그룹에 속한 아이템 생성
        itemInContainerService.createItemInContainer(itemsInContainerRequestDto, container);
        return HttpStatus.OK;
    }

    //그룹내 아이템 리스트 가져오기
    @GetMapping("/items/{containerId}")
    public List<ItemInContainer> ItemInContainerAll(@PathVariable Long containerId) {
        Container container = containerRepository.findByContainerId(containerId);
        return itemInContainerRepository.findAllByContainer(container);
    }
}
