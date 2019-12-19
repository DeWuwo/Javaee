package com.example.demo.model.entity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private Integer role;
    @Column(name = "parent_id")
    private Integer parentId;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_at")
    private Date createAt = new Date();
}
