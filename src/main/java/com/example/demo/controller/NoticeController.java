package com.example.demo.controller;
import com.example.demo.service.NoticeService;
import com.example.demo.util.request.NoticeAddRequest;
import com.example.demo.util.request.NoticeDeleteRequest;
import com.example.demo.util.response.BaseResponse;
import com.example.demo.util.response.LoginData;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/notice")
public class NoticeController {
    @Resource
    NoticeService noticeService;


    @PostMapping
    public BaseResponse addNotice(@RequestBody NoticeAddRequest noticeAddRequest, HttpSession session) {

        String content = noticeAddRequest.getContent();
        String title = noticeAddRequest.getTitle();
        int isTop = noticeAddRequest.getIs_top();
        int type = noticeAddRequest.getType();
        LoginData data = (LoginData) session.getAttribute(session.getId());
        int userId = data.getId();
        noticeService.addNotice(title, type, isTop, content, userId);
        BaseResponse<String> baseResponse = new BaseResponse<>();
        baseResponse.setData("发布通知成功");
        return baseResponse;
    }

    @DeleteMapping
    public BaseResponse deleteNotice(@RequestBody NoticeDeleteRequest noticeDeleteRequest) {
        int[] noticeIds = noticeDeleteRequest.getNotice_id();
        noticeService.deleteNotices(noticeIds);
        BaseResponse<String> baseResponse = new BaseResponse<>();
        baseResponse.setData("删除通知成功");
        return baseResponse;
    }


}
