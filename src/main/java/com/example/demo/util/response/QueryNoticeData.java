package com.example.demo.util.response;


import com.example.demo.model.entity.Notice;
import lombok.Data;

import java.util.List;

@Data
public class QueryNoticeData {

    private List<Notice> notices;

}
