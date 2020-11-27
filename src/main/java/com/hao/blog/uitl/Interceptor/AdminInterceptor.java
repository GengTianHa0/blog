package com.hao.blog.uitl.Interceptor;

import com.hao.blog.object.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminInterceptor implements HandlerInterceptor {


    //在请求处理之前调用preHandle方法
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            User user = (User) request.getSession().getAttribute("user");
            if (user != null) {
                return true;
            }
            response.sendRedirect(request.getContextPath()+"/admin");
        } catch (IOException e) {

            e.printStackTrace();
        }
        return false;
    }
}
