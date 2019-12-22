package com.example.demo.model.repository;

import com.example.demo.model.entity.Recommend;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecommendRespository extends CrudRepository<Recommend, Integer> {

    List<Recommend> findRecommendsByUserId(int Id);
    Recommend findRecommendById(int id);

}
