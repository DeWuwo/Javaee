package com.example.demo.controller;


import com.example.demo.model.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.util.DemoException;
import com.example.demo.util.request.UserAddRequest;
import com.example.demo.util.request.UserDeleteRequest;
import com.example.demo.util.response.BaseResponse;
import com.example.demo.util.response.LoginData;
import com.example.demo.util.response.QueryUserData;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping
    public BaseResponse queryUser(HttpSession session) {
        LoginData loginData = (LoginData) session.getAttribute(session.getId());
        int userId = loginData.getId();
        List<User> users = userService.queryUser(userId);
        QueryUserData queryUserData = new QueryUserData();
        queryUserData.setUsers(users);
        BaseResponse<QueryUserData> baseResponse = new BaseResponse<>();
        baseResponse.setData(queryUserData);
        return baseResponse;
    }



    @PostMapping
    public BaseResponse addNewUser(@RequestBody UserAddRequest userAddRequest, HttpSession session) {
      try {
          String username = userAddRequest.getUsername();
          String password = userAddRequest.getPassword();
          LoginData data = (LoginData) session.getAttribute(session.getId());
          int type = data.getType();
          int parent_id = data.getId();
          userService.checkUsername(username);
          userService.addUser(username, password, type, parent_id);
          BaseResponse<String> baseResponse = new BaseResponse<>();
          baseResponse.setData("添加用户成功");
          return baseResponse;
      } catch (DemoException e) {
          BaseResponse<String> baseResponse = new BaseResponse<>();
          baseResponse.setStatus("error");
          baseResponse.setData(e.getMessage());
          return baseResponse;
      }
    }

    @DeleteMapping
    public BaseResponse deleteUser(@RequestBody UserDeleteRequest userDeleteRequest) {
        int[] userIds = userDeleteRequest.getUser_id();
        userService.deleteUser(userIds);
        BaseResponse<String> baseResponse = new BaseResponse<>();
        baseResponse.setData("删除成功");
        return baseResponse;
    }



}
