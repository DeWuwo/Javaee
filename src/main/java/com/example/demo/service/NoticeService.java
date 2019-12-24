package com.example.demo.service;

import com.example.demo.model.entity.Notice;
import com.example.demo.model.repository.NoticeRespository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class NoticeService {

    @Resource
    NoticeRespository noticeRespository;

    public void addNotice(String title, int type, int isTop, String content, int userId) {
        Notice notice = new Notice();
        notice.setContent(content);
        notice.setIsTop(isTop);
        notice.setTitle(title);
        notice.setType(type);
        notice.setUserId(userId);
        noticeRespository.save(notice);
    }

    @Transactional
    public void deleteNotices(int[] noticeIds) {

        for (int id: noticeIds) {
            noticeRespository.deleteNoticeById(id);
        }

    }

    public List<Notice> queryNotice(int userId) {
        return noticeRespository.findNoticesByUserId(userId);
    }

}
