package com.example.lietenerbox.service;

import com.example.lietenerbox.exception.DataNotFoundException;
import com.example.lietenerbox.model.Container;
import com.example.lietenerbox.model.ItemInContainer;
import com.example.lietenerbox.model.Members;
import com.example.lietenerbox.contoller.requestDto.ItemsInContainerReqDto;
import com.example.lietenerbox.repository.ContainerRepository;
import com.example.lietenerbox.repository.ItemInContainerRepository;
import com.example.lietenerbox.repository.MembersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemInContainerService {

    private final ItemInContainerRepository itemInContainerRepository;
    private final ContainerRepository containerRepository;
    private final MembersRepository membersRepository;

    public ItemInContainerService(ItemInContainerRepository itemInContainerRepository, ContainerRepository containerRepository,MembersRepository membersRepository) {
        this.itemInContainerRepository = itemInContainerRepository;
        this.containerRepository = containerRepository;
        this.membersRepository = membersRepository;
    }



    public List<ItemInContainer> getItemInContainerList(Long itemsInContainerSn){
        List<ItemInContainer> itemInContainerList= itemInContainerRepository.findByContainerItemId(itemsInContainerSn);
        return itemInContainerList;
    }

    public ItemInContainer createItemInContainer(ItemsInContainerReqDto reqDto) {
        Long containerSn = reqDto.getContainerSn();
        String itemName = reqDto.getItemName();
        String itemContents =reqDto.getItemContents();

        Container container = containerRepository.findById(containerSn).orElseThrow(DataNotFoundException::new);

        ItemInContainer itemInContainer = itemInContainerRepository.save(new ItemInContainer(container,itemName,itemContents));
        return itemInContainer;
    }

    public ItemInContainer changeItemsInContainer(ItemsInContainerReqDto reqDto) {
        //컨테이너 수정 정보
        Long containerSn = reqDto.getContainerSn();
        String itemName = reqDto.getItemName();
        String itemContents = reqDto.getItemContents();

        //컨테이너 생성자와 요청자의 일치 확인을 위한 회원정보 가져오기
        Long memSn = reqDto.getMemSn();
        Members members = membersRepository.findByMembersSn(memSn);


        //수정할 기존의 컨테이너 정보 가져오기
        Container container = containerRepository.findById(containerSn).orElseThrow(DataNotFoundException::new);
        String containerOwner = container.getMembers().getMembersId();

        //수정한 컨테이너 정보 담기
        ItemInContainer itemInContainer = new ItemInContainer();
        if(members.getMembersId().equals(containerOwner)){
         itemInContainer = itemInContainerRepository.save(new ItemInContainer(container,itemName,itemContents));
        }
        return itemInContainer;
    }
}
