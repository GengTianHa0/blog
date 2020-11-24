package com.hao.blog.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class LogAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    //规定拦截哪些类
    //com.hao.blog.web.*.*(..)
    //拦截web包下的所有类 类中的所有方法
    @Pointcut("execution(* com.hao.blog.web.*.*(..))")
    public void log() {


    }


    //在拦截之前做的事情
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        //获取HttpRequest
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        String url=request.getRequestURL().toString();
        String ip=request.getRemoteAddr();

        //获取类名和方法名通过切面来获取
        String classMethod=joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName();
        Object[] args=joinPoint.getArgs();
        Requestlog requestlog=new Requestlog(url,ip,classMethod,args);

        logger.info("Request: {} "+requestlog);


    }


    @After("log()")
    public void doAfter() {
        logger.info("===============doAfter==============");
    }

    //方法执行完，返回之后拦截它（return后要做的事情 ）
    @AfterReturning(returning = "result", pointcut = "log()")
    public void doAfterRuturn(Object result) {


        logger.info("Result : {}" + result);

    }


    private class Requestlog{
        private String url;
        private String ip;
        private String classMethod;

        private Object[] args;

        public Requestlog(String url, String ip, String classMethod, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.classMethod = classMethod;
            this.args = args;
        }

        @Override
        public String toString() {
            return "Requestlog{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", classMethod='" + classMethod + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }

}
