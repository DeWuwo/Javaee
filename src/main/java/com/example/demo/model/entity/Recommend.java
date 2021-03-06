package com.example.demo.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "recommend")
@Getter
@Setter
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
    @OneToMany(mappedBy = "recommend", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Img> imgs = new ArrayList<>();

    @Override
    public String toString() {
        return " ";
    }
}
