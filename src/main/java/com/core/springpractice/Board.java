package com.core.springpractice;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
public class Board {
    @Id
    @GeneratedValue
    private Long bno;

    private String title;

    private String writer;

    private String content;

    private Long viewCount;

    @Temporal(TemporalType.TIMESTAMP)
    private Date inDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date upDate;
}
