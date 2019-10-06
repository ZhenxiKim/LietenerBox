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
@Table(name = "container")
public class Groups {
    @Id
    @Column(name = "group_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long groupId;//그룹 pk 아이디
    private String groupName;//그룹 명
    private LocalDateTime createdAt;//그룹 생성 날짜
    private boolean groupStatus;//그룹 상태(활성/비활성)
    private String groupContents;//그룹 소개 설명

    @ManyToOne
    @JoinColumn(name = "person_sn", referencedColumnName = "person_sn", nullable = false)
    private Person person; //Person테이블의 personSn 컬럼 참조

    public Groups(GroupsRequestDto requestDto, Person sessionPerson) {
        this.groupName = requestDto.getGroupName();
        this.createdAt = LocalDateTime.now();
        this.groupStatus = true;
        this.groupContents = requestDto.getGroupContents();
        this.person = sessionPerson;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Groups(String groupName, String groupContents, Person sessionPerson) {
        this.groupName = groupName;
        this.createdAt = LocalDateTime.now();
        this.groupStatus = true;
        this.groupContents = groupContents;
        this.person = sessionPerson;
    }

    private Sort orderByCreatedAtDesc() {
        return new Sort(Sort.Direction.DESC, "createdAt");
    }
}
