package com.example.demo.service;


import com.example.demo.model.entity.User;
import com.example.demo.model.repository.UserRepository;
import com.example.demo.util.DemoException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Component()
public class UserService {

    @Resource
    UserRepository userRepository;

    public void checkUsername(String username) throws DemoException {
        try {
            if (userRepository.findByUsername(username) != null) {
                throw new DemoException("用户名已存在");
            }
        } catch (NullPointerException e) {
            System.out.println("可以创建一个新的用户");
        }
    }

    public void addUser(String username, String password, int type, int parentId) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setParentId(parentId);
        type++;
        user.setRole(type);
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(int[] userIds) {
        for (int id: userIds) {
            userRepository.deleteUserById(id);
        }
    }

}
