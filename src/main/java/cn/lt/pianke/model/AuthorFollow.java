package cn.lt.pianke.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by 刘婷 on 2017/4/27.
 */
@Table(name = "t_author_follow")
public class AuthorFollow {
    private Integer follow_id;
    private Integer id_from;
    private Integer id_to;

    public AuthorFollow() {
    }

    public AuthorFollow(Integer follow_id, Integer id_from, Integer id_to) {
        this.follow_id = follow_id;
        this.id_from = id_from;
        this.id_to = id_to;
    }

    //主键映射
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "follow_id",length = 11,nullable = false)
    public Integer getFollow_id() {
        return follow_id;
    }

    public void setFollow_id(Integer follow_id) {
        this.follow_id = follow_id;
    }
    @Column(name = "id_from",length = 11,nullable = false)
    public Integer getId_from() {
        return id_from;
    }

    public void setId_from(Integer id_from) {
        this.id_from = id_from;
    }
    @Column(name = "id_to",length = 11,nullable = false)
    public Integer getId_to() {
        return id_to;
    }

    public void setId_to(Integer id_to) {
        this.id_to = id_to;
    }

    @Override
    public String toString() {
        return "AuthorFollow{" +
                "follow_id=" + follow_id +
                ", id_from=" + id_from +
                ", id_to=" + id_to +
                '}';
    }
}
