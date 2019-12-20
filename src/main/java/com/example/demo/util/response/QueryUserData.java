package com.example.demo.util.response;


import com.example.demo.model.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class QueryUserData {

    private List<User> users;

}
