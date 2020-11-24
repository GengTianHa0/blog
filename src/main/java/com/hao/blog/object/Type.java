package com.hao.blog.object;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Type {


    @Id
    @GeneratedValue
    private Long id;
    private String name;


    private List<Blog> blogs = new ArrayList<>();

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", blogs=" + blogs +
                '}';
    }
}
