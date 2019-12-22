package com.example.demo.controller;


import com.example.demo.model.entity.Recommend;
import com.example.demo.service.RecommendService;
import com.example.demo.util.response.BaseResponse;
import com.example.demo.util.response.LoginData;
import com.example.demo.util.response.QueryRecommendData;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/img")
public class RecommendController {

    @Resource
    RecommendService recommendService;


    @GetMapping
    public BaseResponse getRecommend(HttpSession session) {
        LoginData loginData = (LoginData)session.getAttribute(session.getId());
        int userId = loginData.getId();
        List<Recommend> recommends = recommendService.getRecommends(userId);
        BaseResponse<QueryRecommendData> baseResponse = new BaseResponse<>();
        QueryRecommendData queryImgData = new QueryRecommendData();
        queryImgData.setCount(recommends.size());
        queryImgData.setRes(recommends);
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
