package com.example.demo.service;

import com.example.demo.model.entity.Img;
import com.example.demo.model.repository.ImgRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.transaction.Transactional;


@Component
public class ImgService {

    @Resource
    ImgRepository imgRepository;


    public void addImg(String name) {
        Img img = new Img();
        img.setName(name);
        imgRepository.save(img);
    }

    public Img getImg(int id) {
        return imgRepository.findImgById(id);
    }

    @Transactional
    public void deleteImg(int[] ids) {

        for (int id: ids) {
            imgRepository.deleteImgById(id);
        }

    }
}
