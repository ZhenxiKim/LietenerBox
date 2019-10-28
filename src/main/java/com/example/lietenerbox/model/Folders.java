package com.example.lietenerbox.model;
import com.example.lietenerbox.contoller.requestDto.ItemsRequestDto;
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
public class Folders {
    @Id
    @Column(name = "itemId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemId;//세트 pk 아이디
    private String itemName;//세트 명
    private LocalDateTime itemCreatedAt;//세트 생성 날짜
    private boolean activeFlag;

    @ManyToOne
    @JoinColumn(name = "members_sn", referencedColumnName = "members_sn", nullable = false)
    private Members members;//members테이블의 membersSn 참조

    //api
    public Folders(ItemsRequestDto itemsRequestDto, Members loginMembers) {
        this.itemName = itemsRequestDto.getItemsName();
        this.itemCreatedAt = LocalDateTime.now();
        this.members = loginMembers;
    }

    public Folders(String itemsName, Members loginMembers){
        this.itemName = itemsName;
        this.itemCreatedAt = LocalDateTime.now();
        this.members = loginMembers;
    }
}
