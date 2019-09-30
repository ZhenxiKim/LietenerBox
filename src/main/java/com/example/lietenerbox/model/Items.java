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
@Table(name = "item")
public class Items {
    @Id
    @Column(name = "itemId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemId;//세트 pk 아이디
    private String itemsName;//세트 명
    private LocalDateTime itemCreatedAt;//세트 생성 날짜

    @ManyToOne
    @JoinColumn(name = "Person_sn", referencedColumnName = "Person_sn", nullable = false)
    private Person person;//Person테이블의 PersonSn 참조

    public Items(ItemsRequestDto itemsRequestDto, Person loginPerson) {
        this.itemsName = itemsRequestDto.getItemsName();
        this.itemCreatedAt = LocalDateTime.now();
        this.person = loginPerson;
    }
}
