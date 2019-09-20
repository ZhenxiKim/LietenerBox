package com.example.lietenerbox.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class WordInGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long groupWordId;

    private String groupWordName;
    private String groupWordMean;
    @Column(nullable = false, columnDefinition = "number(2) default 1")
    private Integer groupWordLevel;
    private String groupWordPhoto;
    private String groupWordPhotoLoc;

    @ManyToOne
    @JoinColumn(name = "itemInGroup_groupItemId")
    private ItemInGroup itemInGroup;

}
