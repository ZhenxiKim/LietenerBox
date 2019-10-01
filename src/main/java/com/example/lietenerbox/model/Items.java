package com.example.lietenerbox.model;

import com.example.lietenerbox.model.dto.request.ItemsRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "items")
public class Items {
    @Id
    @Column(name = "itemId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemId;//세트 pk 아이디
    private String itemName;//세트 명
    private LocalDateTime itemCreatedAt;//세트 생성 날짜

    @ManyToOne
    @JoinColumn(name = "person_sn", referencedColumnName = "person_sn", nullable = false)
    private Person person;//Person테이블의 PersonSn 참조

    //api
    public Items(ItemsRequestDto itemsRequestDto, Person loginPerson) {
        this.itemName = itemsRequestDto.getItemsName();
        this.itemCreatedAt = LocalDateTime.now();
        this.person = loginPerson;
    }

    public Items(String itemsName,Person loginPerson){
        this.itemName = itemsName;
        this.itemCreatedAt = LocalDateTime.now();
        this.person = loginPerson;
    }
}
