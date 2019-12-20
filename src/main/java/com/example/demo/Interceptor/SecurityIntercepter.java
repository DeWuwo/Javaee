package com.example.demo.Interceptor;

import com.alibaba.fastjson.JSON;
import org.springframework.web.servlet.HandlerInterceptor;
import com.example.demo.util.response.BaseResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecurityIntercepter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if (session.getAttribute(session.getId()) != null) {
            return true;
        }
        BaseResponse<String> baseResponse = new BaseResponse<>();
        baseResponse.setStatus("error");
        baseResponse.setData("用户尚未登录");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(JSON.toJSONString(baseResponse));
        return false;
    }
}
