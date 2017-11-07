package cn.lt.pianke.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by 刘婷 on 2017/4/27.
 */
@Table(name = "t_comment")
public class Comment {
    private Integer comment_id;
    private Integer article_id;
    private Integer user_id;
    private String content;
    private Timestamp comment_time;
    public Comment() {
    }

    public Comment(Integer comment_id, Integer article_id, Integer user_id, String content, Timestamp comment_time) {
        this.comment_id = comment_id;
        this.article_id = article_id;
        this.user_id = user_id;
        this.content = content;
        this.comment_time = comment_time;
    }

    //主键映射
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "comment_id",length = 11,nullable = false)
    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }
    @Column(name = "article_id",length = 11,nullable = false)
    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }
    @Column(name = "user_id",length = 11,nullable = false)
    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
    @Column(name = "content",length =500,nullable = false)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    @Column(name = "comment_time",nullable = false)
    public Timestamp getComment_time() {
        return comment_time;
    }

    public void setComment_time(Timestamp comment_time) {
        this.comment_time = comment_time;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "comment_id=" + comment_id +
                ", article_id=" + article_id +
                ", user_id=" + user_id +
                ", content='" + content + '\'' +
                ", comment_time=" + comment_time +
                '}';
    }
}
