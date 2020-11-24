package com.hao.blog.object;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@DynamicUpdate
public class Tag {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
//
//    @OneToMany
//    private List<Blog> blogs = new ArrayList<>();


    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


}
