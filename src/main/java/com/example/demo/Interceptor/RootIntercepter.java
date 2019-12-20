package com.example.demo.Interceptor;

import com.alibaba.fastjson.JSON;
import com.example.demo.util.response.BaseResponse;
import com.example.demo.util.response.LoginData;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RootIntercepter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        LoginData data = (LoginData)session.getAttribute(session.getId());
        // 如果用户类型为root，则继续执行action
        if (data.getType() == 1) {
            return true;
        }
        // 否则，拦截用户请求
        BaseResponse<String> baseResponse = new BaseResponse<>();
        baseResponse.setStatus("error");
        baseResponse.setData("未拥有root权限");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(JSON.toJSONString(baseResponse));
        return false;
    }
}
