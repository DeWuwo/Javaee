package com.example.demo.controller;
import com.example.demo.service.NoticeService;
import com.example.demo.util.request.NoticeAddRequest;
import com.example.demo.util.response.BaseResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/notice")
public class NoticeController {
    @Resource
    NoticeService noticeService;

    @DeleteMapping
    public BaseResponse deleteNotice(@RequestBody NoticeAddRequest noticeAddRequest) {
        int[] noticeIds = noticeAddRequest.getNotice_id();
        noticeService.deleteNotices(noticeIds);
        BaseResponse<String> baseResponse = new BaseResponse<>();
        baseResponse.setData("删除通知成功");
        return baseResponse;
    }


}
