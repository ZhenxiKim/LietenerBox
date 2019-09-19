package com.example.lietenerbox.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Enrollment implements Serializable {

    //복합키로 사용할 컬럼 선언
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long enrollmentId;

    private LocalDateTime subscribeAt;
    private boolean subscribeStatus;

}
