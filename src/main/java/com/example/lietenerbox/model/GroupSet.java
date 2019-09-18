package com.example.lietenerbox.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class GroupSet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long groupSetId;

    private String groupSetName;
    private LocalDateTime groupSetCreatedAt;

}
