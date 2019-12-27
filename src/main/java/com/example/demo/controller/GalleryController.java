package com.example.demo.controller;


import com.example.demo.model.entity.Img;
import com.example.demo.service.ImgService;
import com.example.demo.util.request.ImgDeleteRequest;
import com.example.demo.util.response.BaseResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/gallery")
public class GalleryController {


    @Resource
    ImgService imgService;

    @GetMapping("/{gallery_id}")
    public BaseResponse getImg(@PathVariable("gallery_id") int imgId) {

        Img img = imgService.getImg(imgId);
        BaseResponse<String> baseResponse = new BaseResponse<>();
        baseResponse.setData(img.getName());
        return baseResponse;

    }

    @DeleteMapping("/img")
    public BaseResponse deleteImg(@RequestBody ImgDeleteRequest imgDeleteRequest) {

        int[] imgIds = imgDeleteRequest.getImg_id();
        imgService.deleteImg(imgIds);
        BaseResponse<String> baseResponse = new BaseResponse<>();
        baseResponse.setData("成功删除");
        return baseResponse;

    }

}