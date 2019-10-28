package com.example.lietenerbox.model;

import com.example.lietenerbox.contoller.requestDto.ItemsInContainerRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    private String containerItemName;
    private LocalDateTime containerItemCreatedAt;

    @ManyToOne
    @JoinColumn(name = "container_id",referencedColumnName = "container_id",nullable = false)
    private Container container; //containers테이블의 containerId컬럼 참조

    public ItemInContainer(String itemName, Members sessionMembers, Container itemInContainer){
        this.containerItemName = itemName;
        this.containerItemCreatedAt = LocalDateTime.now();
        this.container = itemInContainer;
    }

    public ItemInContainer(ItemsInContainerRequestDto itemsInContainerRequestDto, Container container) {
        this.containerItemName = itemsInContainerRequestDto.getContainerItemName();
        this.containerItemCreatedAt = LocalDateTime.now();
        this.container = container;
    }
}
