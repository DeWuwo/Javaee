package com.example.demo.controller;


import com.example.demo.model.entity.User;
import com.example.demo.model.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserRepository userRepository;
    @PostMapping("/add")
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String password) {
        User user = new User();
        user.setId(17);
        user.setUsername(name);
        user.setPassword(password);
        userRepository.save(user);
        return "saved";
    }


}
