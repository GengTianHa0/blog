package com.hao.blog.object;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Comment {

    @Id
    @GeneratedValue
    private Long id;
    private String nickname;
    private String email;
    private String content;
    private String avatar;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    private boolean adminComment;
//    @ManyToOne
//    private Blog blog;
//
//    @OneToMany(mappedBy = "parentComment")
//    private List<Comment> replyComments = new ArrayList<>();
//
//    @ManyToOne
//    private Comment parentComment;


    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                ", avatar='" + avatar + '\'' +
                ", createTime=" + createTime +
                ", adminComment=" + adminComment +
                '}';
    }




}
