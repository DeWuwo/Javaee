package com.example.demo.model.repository;

import com.example.demo.model.entity.Img;
import org.springframework.data.repository.CrudRepository;

public interface ImgRepository extends CrudRepository<Img, Integer> {

    Img findImgById(int id);
    void deleteImgById(int id);
}
