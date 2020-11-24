package com.hao.blog.object;


import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@DynamicUpdate
public class Type {


    @Id
    @GeneratedValue
    private Long id;
    private String name;

    //一个blog对多个id
    private Long blogId;


//    private List<Blog> blogs = new ArrayList<>();

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +

                '}';
    }
}
