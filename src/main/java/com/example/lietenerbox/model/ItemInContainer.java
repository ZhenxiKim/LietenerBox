package com.example.lietenerbox.model;

import com.example.lietenerbox.contoller.requestDto.ItemsInContainerReqDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Optional;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "itemInContainer")
public class ItemInContainer {

    @Id
    @Column(name = "containerItemId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long containerItemId;
    private String containerItemContents;
    private String containerItemName;
    private LocalDateTime containerItemCreatedAt;

    @ManyToOne
    @JoinColumn(name = "container_id",referencedColumnName = "container_id",nullable = false)
    private Container container; //containers테이블의 containerId컬럼 참조


//    public ItemInContainer(ItemsInContainerReqDto itemsInContainerReqDto, Container container) {
//        this.containerItemName = itemsInContainerReqDto.ge();
//        this.containerItemCreatedAt = LocalDateTime.now();
//        this.container = container;
//    }

    public ItemInContainer(Container container, String itemName, String itemContents) {
        this.containerItemName = itemName;
        this.containerItemContents = itemContents;
        this.containerItemCreatedAt = LocalDateTime.now();
        this.container = container;

    }


}
