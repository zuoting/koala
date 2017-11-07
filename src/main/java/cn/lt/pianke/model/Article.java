package cn.lt.pianke.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by 刘婷 on 2017/6/8.
 */
@Table(name = "t_article")
public class Article {
    private Integer article_id;
    private Integer topic_id;
    private Integer user_id;
    private String title;
    private String content;
    private String thumbnail;
    private Integer words_count;
    private Integer read_count;
    private Integer comment_count;
    private Integer like_count;
    private Timestamp write_time;
    private String song_url;
    private Integer play_count;

    public Article() {
    }

    public Article(Integer article_id, Integer topic_id, Integer user_id, String title, String content, String thumbnail, Integer words_count, Integer read_count, Integer comment_count, Integer like_count, Timestamp write_time, String song_url, Integer play_count) {
        this.article_id = article_id;
        this.topic_id = topic_id;
        this.user_id = user_id;
        this.title = title;
        this.content = content;
        this.thumbnail = thumbnail;
        this.words_count = words_count;
        this.read_count = read_count;
        this.comment_count = comment_count;
        this.like_count = like_count;
        this.write_time = write_time;
        this.song_url = song_url;
        this.play_count = play_count;
    }

    //主键映射
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "article_id",length = 11,nullable = false)
    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }
    @Column(name = "topic_id",length = 11,nullable = false)
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
    @Column(name = "title",length = 100,nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Column(name = "content",nullable = false)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    @Column(name = "thumbnail",length = 50,nullable = false)
    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
    @Column(name = "words_count",length = 11,nullable = false)
    public Integer getWords_count() {
        return words_count;
    }

    public void setWords_count(Integer words_count) {
        this.words_count = words_count;
    }
    @Column(name = "read_count",length = 11,nullable = false)
    public Integer getRead_count() {
        return read_count;
    }

    public void setRead_count(Integer read_count) {
        this.read_count = read_count;
    }
    @Column(name = "comment_count",length = 11,nullable = false)
    public Integer getComment_count() {
        return comment_count;
    }

    public void setComment_count(Integer comment_count) {
        this.comment_count = comment_count;
    }
    @Column(name = "like_count",length = 11,nullable = false)
    public Integer getLike_count() {
        return like_count;
    }

    public void setLike_count(Integer like_count) {
        this.like_count = like_count;
    }
    @Column(name = "write_time",nullable = false)
    public Timestamp getWrite_time() {
        return write_time;
    }

    public void setWrite_time(Timestamp write_time) {
        this.write_time = write_time;
    }


    @Column(name = "song_url",length = 50,nullable = false)
    public String getSong_url() {
        return song_url;
    }

    public void setSong_url(String song_url) {
        this.song_url = song_url;
    }

    @Column(name = "play_count",length = 11,nullable = false)
    public Integer getPlay_count() {
        return play_count;
    }

    public void setPlay_count(Integer play_count) {
        this.play_count = play_count;
    }

    @Override
    public String toString() {
        return "Article{" +
                "article_id=" + article_id +
                ", topic_id=" + topic_id +
                ", user_id=" + user_id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", words_count=" + words_count +
                ", read_count=" + read_count +
                ", comment_count=" + comment_count +
                ", like_count=" + like_count +
                ", write_time=" + write_time +
                ", song_url='" + song_url + '\'' +
                ", play_count=" + play_count +
                '}';
    }
}
