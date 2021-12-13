package com.atduu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_blog")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;  //标题
    private String content;  //内容
    private String firstPicture;  //首图
    private String flag;  //标签
    private Integer views; //浏览数
    private boolean appreciation;  //是否开启赞赏
    private boolean shareStatement;  //是否分享声明
    private boolean commentAble;  //是否可评论
    private boolean published;  //是否发布
    private boolean recommend;  //是否推荐

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;    //创建时间

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;    //更新时间

    @ManyToOne
    private Type type;

    //级联新增
    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Tag> tags = new ArrayList<>();

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "blog")
    private List<Comment> comments = new ArrayList<>();

    @Transient
    private String tagIds;

}