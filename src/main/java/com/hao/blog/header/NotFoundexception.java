package com.hao.blog.header;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * @ResponseStatus(HttpStatus.NOT_FOUND)
 *
 * 判定该状态为资源找不到的状态
 * 目的是使界面直接跳转到404.html
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundexception extends RuntimeException{



    public NotFoundexception(){

    }


    public NotFoundexception(String message){

        super(message);
    }


    public NotFoundexception(String message , Throwable cause){

        super(message,cause);
    }


}
