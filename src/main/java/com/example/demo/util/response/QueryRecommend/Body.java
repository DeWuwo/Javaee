package com.example.demo.util.response.QueryRecommend;

import lombok.Data;

import java.util.List;

@Data
public class Body {
    private int comment = 0;
    private String content;
    private int id = 0;
    private List<ImgUrl> imgUrls;
}
