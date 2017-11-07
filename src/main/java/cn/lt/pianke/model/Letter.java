package cn.lt.pianke.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by 刘婷 on 2017/4/27.
 */
@Table(name = "t_letter")
public class Letter {
    private Integer letter_id;
    private Integer from_id;
    private Integer to_id;
    private String content;
    private Timestamp letter_time;

    public Letter() {
    }

    public Letter(Integer from_id, Integer to_id, String content, Timestamp letter_time) {
        this.from_id = from_id;
        this.to_id = to_id;
        this.content = content;
        this.letter_time = letter_time;
    }
    //主键映射
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "letter_id",length = 11,nullable = false)
    public Integer getLetter_id() {
        return letter_id;
    }

    public void setLetter_id(Integer letter_id) {
        this.letter_id = letter_id;
    }
    @Column(name = "from_id",length = 11,nullable = false)
    public Integer getFrom_id() {
        return from_id;
    }

    public void setFrom_id(Integer from_id) {
        this.from_id = from_id;
    }
    @Column(name = "to_id",length = 11,nullable = false)
    public Integer getTo_id() {
        return to_id;
    }

    public void setTo_id(Integer to_id) {
        this.to_id = to_id;
    }
    @Column(name = "content",length =200,nullable = false)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    @Column(name = "letter_time",nullable = false)
    public Timestamp getLetter_time() {
        return letter_time;
    }

    public void setLetter_time(Timestamp letter_time) {
        this.letter_time = letter_time;
    }

    @Override
    public String toString() {
        return "Letter{" +
                "letter_id=" + letter_id +
                ", from_id=" + from_id +
                ", to_id=" + to_id +
                ", content='" + content + '\'' +
                ", letter_time=" + letter_time +
                '}';
    }
}
