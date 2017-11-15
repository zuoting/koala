package cn.lt.pianke.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by 刘婷 on 2017/6/8.
 */
@Table (name = "t_timeline")
public class Timeline {
    private Integer timeline_id;
    private Integer label_id;
    private Integer user_id;
    private Timestamp write_time;
    private String pic_url;
    private String content;
    private Integer like_count;
    private Integer comment_count;

    public Timeline() {
    }

    public Timeline(Integer timeline_id, Integer label_id, Integer user_id, Timestamp write_time, String pic_url, String content, Integer like_count, Integer comment_count) {
        this.timeline_id = timeline_id;
        this.label_id = label_id;
        this.user_id = user_id;
        this.write_time = write_time;
        this.pic_url = pic_url;
        this.content = content;
        this.like_count = like_count;
        this.comment_count = comment_count;
    }
    public Timeline(Integer label_id, Integer user_id,String pic_url, String content, Integer like_count, Integer comment_count) {
        this.label_id = label_id;
        this.user_id = user_id;
        this.pic_url = pic_url;
        this.content = content;
        this.like_count = like_count;
        this.comment_count = comment_count;
    }

    //主键映射
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "topic_id",length = 11,unique = true,nullable = false)
    public Integer getTimeline_id() {
        return timeline_id;
    }

    public void setTimeline_id(Integer timeline_id) {
        this.timeline_id = timeline_id;
    }
    @Column(name = "label_id",length = 11,nullable = false)
    public Integer getLabel_id() {
        return label_id;
    }

    public void setLabel_id(Integer label_id) {
        this.label_id = label_id;
    }
    @Column(name = "user_id",length = 11,nullable = false)
    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
    @Column(name = "write_time",nullable = false)
    public Timestamp getWrite_time() {
        return write_time;
    }

    public void setWrite_time(Timestamp write_time) {
        this.write_time = write_time;
    }

    @Column(name = "pic_url",length = 50,nullable = false)
    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    @Column(name = "content",nullable = false)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    @Column(name = "like_count",length = 11,nullable = false)
    public Integer getLike_count() {
        return like_count;
    }

    public void setLike_count(Integer like_count) {
        this.like_count = like_count;
    }
    @Column(name = "comment_count",length = 11,nullable = false)
    public Integer getComment_count() {
        return comment_count;
    }

    public void setComment_count(Integer comment_count) {
        this.comment_count = comment_count;
    }

    @Override
    public String toString() {
        return "Timeline{" +
                "timeline_id=" + timeline_id +
                ", label_id=" + label_id +
                ", user_id=" + user_id +
                ", write_time=" + write_time +
                ", pic_url='" + pic_url + '\'' +
                ", content='" + content + '\'' +
                ", like_count=" + like_count +
                ", comment_count=" + comment_count +
                '}';
    }
}
