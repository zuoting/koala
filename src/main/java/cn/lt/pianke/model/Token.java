package cn.lt.pianke.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by 刘婷 on 2017/4/27.
 */
@Table(name = "t_token")
public class Token {
    private Integer id;
    private Integer user_id;
    private String token;

    public Token() {
    }

    public Token(Integer id, Integer user_id, String token) {
        this.id = id;
        this.user_id = user_id;
        this.token = token;
    }
    //主键映射
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "id",length = 11,nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name = "user_id",length = 11,nullable = false)
    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
    @Column(name = "token",length = 200,nullable = false)
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Token{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", token='" + token + '\'' +
                '}';
    }
}
