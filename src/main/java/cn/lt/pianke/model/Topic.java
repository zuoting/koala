package cn.lt.pianke.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by 刘婷 on 2017/6/8.
 */
@Table(name="t_topic")
public class Topic {
    private Integer topic_id;
    private Integer user_id;
    private String topic_name;
    private String logo;
    private Integer article_count;
    private String topic_type;

    public Topic() {
    }

    public Topic(Integer topic_id, Integer user_id, String topic_name, String logo, Integer article_count, String topic_type) {
        this.topic_id = topic_id;
        this.user_id = user_id;
        this.topic_name = topic_name;
        this.logo = logo;
        this.article_count = article_count;
        this.topic_type = topic_type;
    }

    //主键映射
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "topic_id",length = 11,unique = true,nullable = false)
    public Integer getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(Integer topic_id) {
        this.topic_id = topic_id;
    }
    @Column(name = "user_id",length = 11,nullable = false)
    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
    @Column(name = "topic_name",length = 20,nullable = false)
    public String getTopic_name() {
        return topic_name;
    }

    public void setTopic_name(String topic_name) {
        this.topic_name = topic_name;
    }
    @Column(name = "logo",length = 50,nullable = false)
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
    @Column(name = "article_count",length = 11,nullable = false)
    public Integer getArticle_count() {
        return article_count;
    }

    public void setArticle_count(Integer article_count) {
        this.article_count = article_count;
    }
    @Column(name = "topic_type",length = 20,nullable = false)
    public String getTopic_type() {
        return topic_type;
    }

    public void setTopic_type(String topic_type) {
        this.topic_type = topic_type;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "topic_id=" + topic_id +
                ", user_id=" + user_id +
                ", topic_name='" + topic_name + '\'' +
                ", logo='" + logo + '\'' +
                ", article_count=" + article_count +
                ", topic_type='" + topic_type + '\'' +
                '}';
    }
}
