package com.example.lietenerbox.model;

import com.example.lietenerbox.contoller.requestDto.ContainerRequestDto;
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
public class Container {
    @Id
    @Column(name = "container_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long containerId;//그룹 pk 아이디
    private String containerName;//그룹 명
    private LocalDateTime createdAt;//그룹 생성 날짜
    private boolean containerStatus;//그룹 상태(활성/비활성)
    private String containerContents;//그룹 소개 설명

    @ManyToOne
    @JoinColumn(name = "members_sn", referencedColumnName = "members_sn", nullable = false)
    private Members members; //members테이블의 membersSn 컬럼 참조

    public Container(Members members, String containerName, String containerContents) {
        this.containerName = containerName;
        this.createdAt = LocalDateTime.now();
        this.containerStatus = true;
        this.containerContents = containerContents;
        this.members = members;
    }

    public Members getMembers() {
        return members;
    }

    public void setMembers(Members members) {
        this.members = members;
    }



    private Sort orderByCreatedAtDesc() {
        return new Sort(Sort.Direction.DESC, "createdAt");
    }


}
