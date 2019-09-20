package com.example.lietenerbox.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "setInGroup")
public class SetInGroup {

    @Id
    @Column(name = "groupSetId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long groupSetId;

    private String groupSetName;
    private LocalDateTime groupSetCreatedAt;

    @ManyToOne
    @JoinColumn(name = "groups_groupId")
    private Groups groups;

}
