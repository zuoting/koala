package cn.lt.pianke.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by 刘婷 on 2017/6/10.
 */
@Table(name = "t_timelineComment")
public class TimelineComment {
    private Integer timeline_comment_id;
    private Integer timeline_id;
    private Integer user_id;
    private String content;
    private Timestamp comment_time;

    public TimelineComment() {
    }

    public TimelineComment(Integer timeline_id, Integer user_id, String content, Timestamp comment_time) {
        this.timeline_id = timeline_id;
        this.user_id = user_id;
        this.content = content;
        this.comment_time = comment_time;
    }

    //主键映射
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "timeline_comment_id",length = 11,nullable = false)
    public Integer getTimeline_comment_id() {
        return timeline_comment_id;
    }

    public void setTimeline_comment_id(Integer timeline_comment_id) {
        this.timeline_comment_id = timeline_comment_id;
    }
    @Column(name = "timeline_id",length = 11,nullable = false)
    public Integer getTimeline_id() {
        return timeline_id;
    }

    public void setTimeline_id(Integer timeline_id) {
        this.timeline_id = timeline_id;
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
        return "TimelineComment{" +
                "timelineComment_id=" + timeline_comment_id +
                ", timeline_id=" + timeline_id +
                ", user_id=" + user_id +
                ", content='" + content + '\'' +
                ", comment_time=" + comment_time +
                '}';
    }
}
