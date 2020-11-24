package com.hao.blog.web;


import com.hao.blog.header.NotFoundexception;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {


    @GetMapping("/a")
    public String index( ) {
//        int i=9/0;

//        String blog = null;
//a
//        if (blog == null) {
//            throw new NotFoundexception("博客不存在");
//        }
        System.out.println("===========index============");
        return "index";
    }

}
