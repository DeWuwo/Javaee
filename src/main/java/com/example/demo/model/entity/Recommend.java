package com.example.demo.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "recommend")
@Data
public class Recommend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_at")
    private Date createAt = new Date();
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "delete_at")
    private Date deleteAt = new Date();
    @Column(name = "user_id")
    private Integer userId;

}
