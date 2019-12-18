package com.example.demo.util.response;


import lombok.Data;

@Data
public class BaseResponse<T> {

    private String status = "success";
    private T data;

}
