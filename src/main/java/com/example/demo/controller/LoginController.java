package com.example.demo.controller;


import com.example.demo.model.entity.User;
import com.example.demo.util.DemoException;
import com.example.demo.util.response.LoginData;
import org.springframework.web.bind.annotation.*;
import com.example.demo.util.request.LoginRequest;
import com.example.demo.service.LoginService;
import com.example.demo.util.response.BaseResponse;

import javax.annotation.Resource;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Resource
    LoginService loginService;

    @PostMapping
    public BaseResponse Login(@RequestBody LoginRequest loginRequest) {


        try {
            String username = loginRequest.getUsername();
            String password = loginRequest.getPassword();
            loginService.checkValidation(username, password);
            User user = loginService.checkPassword(username, password);
            LoginData loginData = new LoginData();
            loginData.setId(user.getId());
            loginData.setType(user.getRole());
            BaseResponse<LoginData> baseResponse = new BaseResponse<>();
            baseResponse.setData(loginData);
            return (baseResponse);
        } catch (DemoException e) {
            BaseResponse<String> baseResponse = new BaseResponse<>();
            baseResponse.setStatus("error");
            baseResponse.setData(e.getMessage());
            return baseResponse;
        }

    }

}
