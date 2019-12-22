package com.example.demo.service;

import com.example.demo.model.entity.Recommend;
import com.example.demo.model.repository.RecommendRespository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class RecommendService {

    @Resource
    RecommendRespository recommendRespository;

    public List<Recommend> getRecommends(int userId) {

        return recommendRespository.findRecommendsByUserId(userId);

    }

    public Recommend getRecommendInfo(int recommendId) {

        return recommendRespository.findRecommendById(recommendId);

    }

}
