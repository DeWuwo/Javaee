package com.example.demo.service;

import com.example.demo.model.entity.Img;
import com.example.demo.model.repository.ImgRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class ImgService {

    @Resource
    ImgRepository imgRepository;


    public void addImg(String name) {
        Img img = new Img();
        img.setName(name);
        imgRepository.save(img);
    }


}
