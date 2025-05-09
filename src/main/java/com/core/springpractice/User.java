package com.core.springpractice;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
public class User {
    @Id
    @Column(name="user_id")
    private String id;

    private String password;

    private String name;

    private String email;

    private Date inDate;

    private Date upDate;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", inDate=" + inDate +
                ", upDate=" + upDate +
                '}';
    }
}
