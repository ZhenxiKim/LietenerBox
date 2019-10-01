package com.example.lietenerbox.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@Table(name = "personRole")
@EqualsAndHashCode(of = "fno")
public class PersonRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long fno;
    private String roleName;
}
