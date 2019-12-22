package com.example.demo.model.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class Img {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer type;
    @ManyToOne
    @JoinColumn(name = "recommend_id")
    private Recommend recommend;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "dir_id")
    private Integer dirId;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_at")
    private Date createAt = new Date();
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "delete_at")
    private Date deleteAt = new Date();

    @Override
    public String toString() {
        return " ";
    }
}
