package com.hao.blog.object;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tag {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany
    private List<Blog> blogs = new ArrayList<>();


    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


}
