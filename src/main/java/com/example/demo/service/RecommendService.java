package com.example.demo.service;


import com.example.demo.model.entity.Img;
import com.example.demo.model.entity.Recommend;
import com.example.demo.model.repository.RecommendRespository;
import com.example.demo.util.response.QueryRecommend.Body;
import com.example.demo.util.response.QueryRecommend.ImgUrl;
import com.example.demo.util.response.QueryRecommend.QueryRecommendData;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class RecommendService {

    @Resource
    RecommendRespository recommendRespository;
    @Transactional
    public QueryRecommendData getRecommends(int userId) {

        List<Recommend> recommends = recommendRespository.findRecommendsByUserId(userId);
        QueryRecommendData queryRecommendData = new QueryRecommendData();
        queryRecommendData.setCount(recommends.size());
        List<Body> bodies = new ArrayList<>();
        for (Recommend recommend: recommends) {
            Body body = new Body();
            body.setContent(recommend.getContent());
            body.setId(recommend.getId());
            List<Img> imgs = recommend.getImgs();
            List<ImgUrl> imgUrls = new ArrayList<>();
            for (Img img: imgs) {
                ImgUrl imgUrl = new ImgUrl();
                imgUrl.setId(img.getId());
                imgUrl.setName(img.getName());
                imgUrls.add(imgUrl);
            }
            body.setImgUrls(imgUrls);
            bodies.add(body);
        }

        queryRecommendData.setRes(bodies);
        return queryRecommendData;

    }

    public Recommend getRecommendInfo(int recommendId) {

        return recommendRespository.findRecommendById(recommendId);

    }


    @Transactional
    public void deleteRecommend(int[] recommendIds) {

        for (int recommendId : recommendIds) {
            recommendRespository.deleteRecommendById(recommendId);
        }

    }

}
