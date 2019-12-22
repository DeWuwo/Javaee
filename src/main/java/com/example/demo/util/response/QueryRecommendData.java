package com.example.demo.util.response;


import com.example.demo.model.entity.Recommend;
import lombok.Data;

import java.util.List;

@Data
public class QueryRecommendData {

    private int count;
    private List<Recommend> res;

}

