package com.example.demo.model.entity;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private Integer role;
    @ColumnDefault("0")
    private Integer sex;
    private String phone;
    private String nickname;
    private String email;
    @Column(name = "parent_id")
    private Integer parentId;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_at")
    private Date createAt = new Date();
}
