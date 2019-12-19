package com.example.demo.model.repository;

import com.example.demo.model.entity.Notice;
import org.springframework.data.repository.CrudRepository;

public interface NoticeRespository extends CrudRepository<Notice, Integer> {
    Notice findNoticeById(int id);
    void deleteNoticeById(int id);
}
