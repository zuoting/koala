package cn.lt.pianke.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by 刘婷 on 2017/4/27.
 */
@Table(name = "t_like")
public class Like {
    private Integer like_id;
    private Integer user_id;
    private Integer article_id;

    public Like() {
    }

    public Like(Integer like_id, Integer user_id, Integer article_id) {
        this.like_id = like_id;
        this.user_id = user_id;
        this.article_id = article_id;
    }
    //主键映射
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "like_id",length = 11,nullable = false)
    public Integer getLike_id() {
        return like_id;
    }

    public void setLike_id(Integer like_id) {
        this.like_id = like_id;
    }
    @Column(name = "user_id",length = 11,nullable = false)
    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
    @Column(name = "article_id",length = 11,nullable = false)
    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }

    @Override
    public String toString() {
        return "Like{" +
                "like_id=" + like_id +
                ", user_id=" + user_id +
                ", article_id=" + article_id +
                '}';
    }
}
