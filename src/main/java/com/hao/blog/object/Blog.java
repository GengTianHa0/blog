package com.hao.blog.object;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Blog {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @Basic(fetch = FetchType.LAZY)
    @Lob
    private String content;
    private String firstPicture;
    private String flag;
    private Integer views;
    private boolean appreciation;
    private boolean shareStatement;
    private boolean commentabled;
    private boolean published;
    private boolean recommend;
    //获得年月日时分秒
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;


//   多对1  private Type type;
//
//
//   1-n  private List<Tag> tags = new ArrayList<>();


}
