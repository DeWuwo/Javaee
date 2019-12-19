package com.example.demo.util.request;


import lombok.Data;

@Data
public class NoticeAddRequest {

    private String title;
    private int type;
    private int is_top;
    private String content;

}
