package com.hao.blog.header;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

//@ControllerAdvice：增强器
//拦截住所有标有Controller的控制器
@ControllerAdvice
public class ControllerExceptionHandler {

    //拿到日志对象
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //处理Controller中（ControllerAdvice）所有的Exception方法
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHander(HttpServletRequest request, Exception e) throws Exception {
        //在控制台输出异常信息
        logger.error("Requst URL : {}, Exception : {}", request.getRequestURL(), e);

        //拦截的是所有的Excption，所以一些标有状态码的也被直接处理返回error界面，这段代码的目的就是
        //抛出那些带有返回码的界面 让springboot本身去处理 (例如404等)
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) !=  null){

            throw e;
        }

        ModelAndView mv = new ModelAndView();
        mv.addObject("url", request.getRequestURL());
        mv.addObject("exception", e);
//返回的是哪个页面
        mv.setViewName("error/error");

        return mv;
    }

}
