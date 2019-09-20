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
@Table(name = "itemInGroup")
public class ItemInGroup {

    @Id
    @Column(name = "groupSetId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long groupItemId;

    private String groupItemName;
    private LocalDateTime groupItemCreatedAt;

    @ManyToOne
    @JoinColumn(name = "groups_groupId")
    private Groups groups;

}
