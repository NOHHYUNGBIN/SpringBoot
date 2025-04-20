package com.core.springpractice;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Setter
@Getter
@Entity
public class Board {
    @Id
    private Long bno;

    private String title;

    private String content;

    private Long viewCnt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @Temporal(TemporalType.TIMESTAMP)
    private Date inDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date upDate;

    @Override
    public String toString() {
        return "Board{" +
                "bno=" + bno +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", viewCnt=" + viewCnt +
                ", user=" + user +
                ", inDate=" + inDate +
                ", upDate=" + upDate +
                '}';
    }
}
