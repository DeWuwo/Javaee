package com.example.demo.model.repository;

import com.example.demo.model.entity.Notice;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NoticeRespository extends CrudRepository<Notice, Integer> {
    void deleteNoticeById(int id);
    List<Notice> findNoticesByUserId(int id);
}
