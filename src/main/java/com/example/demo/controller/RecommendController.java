package com.example.demo.controller;


import com.example.demo.model.entity.Recommend;
import com.example.demo.service.RecommendService;
import com.example.demo.util.response.BaseResponse;
import com.example.demo.util.response.LoginData;
import com.example.demo.util.response.QueryRecommend.QueryRecommendData;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/img")
public class RecommendController {

    @Resource
    RecommendService recommendService;


    @GetMapping
    public BaseResponse getRecommend(HttpSession session) {
        LoginData loginData = (LoginData)session.getAttribute(session.getId());
        int userId = loginData.getId();
        BaseResponse<QueryRecommendData> baseResponse = new BaseResponse<>();
        QueryRecommendData queryImgData = recommendService.getRecommends(userId);
        baseResponse.setData(queryImgData);
        return baseResponse;
    }

    @GetMapping("/{recommandId}")
    public BaseResponse getRecommendInfo(@PathVariable("recommandId") int recommendId) {

        BaseResponse<Recommend> baseResponse = new BaseResponse<>();
        Recommend recommend = recommendService.getRecommendInfo(recommendId);
        baseResponse.setData(recommend);
        return baseResponse;

    }

}
