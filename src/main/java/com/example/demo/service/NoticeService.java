package com.example.demo.service;

import com.example.demo.model.repository.NoticeRespository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Component
public class NoticeService {

    @Resource
    NoticeRespository noticeRespository;

    @Transactional
    public void deleteNotices(int[] noticeIds) {

        for (int id: noticeIds) {
            noticeRespository.deleteNoticeById(id);
        }

    }

}
