package com.hao.blog.service.impl;

import com.hao.blog.object.Type;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class TypeServiceImplTest {


    @Autowired
    private  TypeServiceImpl typeService;


    @Test
    public  void getType(){
        Type type= typeService.getType((long) 1);

        Assert.assertNotNull(type);
    }

    @Test
    public void listType(){
        PageRequest pageRequest=PageRequest.of(1,2);
    Page<Type> typePage= typeService.listType(pageRequest);

       for (Type type:typePage){
           System.out.println(typePage.getNumber());
       }


    }


    @Test
    public void  updateType(){
        Type type=new Type();
        type.setId((long) 1);
        type.setName("aaaaa");
        typeService.updateType((long) 1,type);
    }

}