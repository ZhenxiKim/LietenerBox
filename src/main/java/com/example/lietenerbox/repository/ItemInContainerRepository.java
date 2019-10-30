package com.example.lietenerbox.repository;

import com.example.lietenerbox.model.Container;
import com.example.lietenerbox.model.ItemInContainer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemInContainerRepository extends JpaRepository<ItemInContainer, Long> {

    //사용자 생성 세트
    List<ItemInContainer> findAllByContainer(Container container);
    List<ItemInContainer> findByContainerItemId(Long containerItemId);
    ItemInContainer findByContainer(Container container);
    ItemInContainer findByContainerItemName(String containerItemName);

}
