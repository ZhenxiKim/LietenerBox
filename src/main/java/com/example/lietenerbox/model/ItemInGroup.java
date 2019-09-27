package com.example.lietenerbox.model;

import com.example.lietenerbox.model.dto.request.ItemsInGroupRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "itemInGroup")
public class ItemInGroup {

    @Id
    @Column(name = "groupSetId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long groupItemId;

    private String groupItemName;
    private LocalDateTime groupItemCreatedAt;

    @ManyToOne
    @JoinColumn(name = "groupId",referencedColumnName = "groupId",nullable = false)
    private Groups groups; //Groups테이블의 groupId컬럼 참조

    public ItemInGroup(String itemName, Member sessionMember,Groups itemIngroup){
        this.groupItemName = itemName;
        this.groupItemCreatedAt = LocalDateTime.now();
        this.groups = itemIngroup;
    }

    public ItemInGroup(ItemsInGroupRequestDto itemsInGroupRequestDto, Groups groups) {
        this.groupItemName = itemsInGroupRequestDto.getGroupItemName();
        this.groupItemCreatedAt = LocalDateTime.now();
        this.groups = groups;
    }
}
