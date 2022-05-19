package com.atduu.pojo;

import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_blog")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;  //标题

    @Basic(fetch = FetchType.LAZY)//懒加载
    @Lob   //大字段类型
    private String content;  //内容

    private String firstPicture;  //首图
    private String flag;  //标签
    private Integer views; //浏览数
    private String ques = "-1";  //文章的加密问题
    private String ans;  //加密答案

    private boolean appreciation;  //是否开启赞赏
    private boolean commentAble;  //是否可评论
    private boolean published;  //是否发布
    private boolean recommend;  //是否推荐 (置顶)
    private String description;

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

    @OneToMany(mappedBy = "blog" , cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    @Transient
    private String tagIds;


    public void init(){
        this.tagIds = convertToStrings(this.getTags());
    }

    private String convertToStrings(@Nullable List<Tag> tags){
        if(!tags.isEmpty()){
            StringBuffer ids = new StringBuffer();
            boolean flag = false;
            for (Tag tag : tags){
                if (flag){
                    ids.append(",");
                }else {
                    flag = true;
                }
                ids.append(tag.getId());
            }
            return ids.toString();
        }else {
            return tagIds;
        }
    }

}