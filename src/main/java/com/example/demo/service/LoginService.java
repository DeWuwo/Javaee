package com.example.demo.service;

import com.example.demo.model.entity.User;
import com.example.demo.model.repository.UserRepository;

import javax.annotation.Resource;
import com.example.demo.util.DemoException;
import org.springframework.stereotype.Component;


@Component("LoginService")
public class LoginService {
    @Resource
    private UserRepository userRepository;

    public void checkValidation(String username, String password) throws DemoException{
        if (username == null || username.isEmpty()) {
            throw new DemoException("用户名不能为空");
        } else if (password == null || password.isEmpty()) {
            throw new DemoException("密码不能为空");
        }
    }


    public User checkPassword(String username, String password) throws DemoException {
       try {
           User user = userRepository.findByUsername(username);
           if (!password.equals(user.getPassword())) {
               throw new DemoException("密码错误");
           }
           return user;
       } catch (NullPointerException e) {
           System.out.println("无法登录，数据库中不存在该用户");
           throw new DemoException(("用户不存在"));
       }
    }
}
