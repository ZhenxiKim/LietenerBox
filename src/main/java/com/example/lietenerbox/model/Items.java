package com.example.lietenerbox.model;

import com.example.lietenerbox.model.dto.request.ItemsRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "item")
public class Items {
    @Id
    @Column(name = "setId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemId;//세트 pk 아이디

    private String itemsName;//세트 명
    private LocalDateTime itemCreatedAt;//세트 생성 날짜

    @ManyToOne
    @JoinColumn(name = "member_sn", referencedColumnName = "member_sn", nullable = false)
    private Member member;//Member테이블의 memberSn 참조


    public Items(ItemsRequestDto itemsRequestDto, Member loginMember) {
        this.itemsName = itemsRequestDto.getItemsName();
        this.itemCreatedAt = LocalDateTime.now();
        this.member = loginMember;
    }
}
