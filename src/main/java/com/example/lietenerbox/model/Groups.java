package com.example.lietenerbox.model;

import com.example.lietenerbox.model.dto.request.GroupsRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Sort;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "groups")
public class Groups {
    @Id
    @Column(name = "groupId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long groupId;//그룹 pk 아이디
    private String groupName;//그룹 명
    private LocalDateTime createdAt;//그룹 생성 날짜
    private boolean groupStatus;//그룹 상태(활성/비활성)
    private String groupContents;//그룹 소개 설명

    @ManyToOne
    @JoinColumn(name = "member_sn", referencedColumnName = "member_sn", nullable = false)
    private Member member; //Member테이블의 memId컬럼 참조

    public Groups(GroupsRequestDto requestDto, Member sessionMember) {
        this.groupName = requestDto.getGroupName();
        this.createdAt = LocalDateTime.now();
        this.groupStatus = true;
        this.groupContents = requestDto.getGroupContents();
        this.member = sessionMember;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Groups(String groupName, String groupContents, Member sessionMember) {
        this.groupName = groupName;
        this.createdAt = LocalDateTime.now();
        this.groupStatus = true;
        this.groupContents = groupContents;
        this.member = sessionMember;
    }

    private Sort orderByCreatedAtDesc() {
        return new Sort(Sort.Direction.DESC, "createdAt");
    }
}
