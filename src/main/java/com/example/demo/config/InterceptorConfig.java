package com.example.demo.config;


import com.example.demo.Interceptor.AdminIntercepter;
import com.example.demo.Interceptor.RootIntercepter;
import com.example.demo.Interceptor.SecurityIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {


    // 添加拦截器链
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SecurityIntercepter())
                //排除拦截
                .excludePathPatterns("/login")
                .excludePathPatterns("/logout")
                //拦截路径
                .addPathPatterns("/**");

        registry.addInterceptor(new AdminIntercepter())
                .addPathPatterns("/user/**")
                .addPathPatterns("/notice");

        registry.addInterceptor(new RootIntercepter())
                .addPathPatterns("/img/upload");
    }
}
