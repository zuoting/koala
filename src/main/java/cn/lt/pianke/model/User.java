package cn.lt.pianke.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by 刘婷 on 2017/6/7.
 * 持久化类
 */
@Table(name = "t_user")
public class User {
    //主键映射
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "user_id",nullable = false)
    private Integer user_id;
    private String account;
    private String password;
    private String nickname;
    private String head;
    private String description;
    private int fans_count;
    private int follow_count;
    private int letter_count;

    public User() {
    }

    public User(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public User(String account, String password, String nickname, String head, String description, int fans_count, int follow_count, int letter_count) {
        this.account = account;
        this.password = password;
        this.nickname = nickname;
        this.head = head;
        this.description = description;
        this.fans_count = fans_count;
        this.follow_count = follow_count;
        this.letter_count = letter_count;
    }


    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
    @Column(name = "account",length = 20,nullable = false)
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
    @Column(name = "password",length = 20,nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Column(name = "nickname",length = 20,nullable = false)
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    @Column(name = "head",length = 50,nullable = false)
    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }
    @Column(name = "description",length = 200,nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "fans_count",length = 11,nullable = false)
    public int getFans_count() {
        return fans_count;
    }

    public void setFans_count(int fans_count) {
        this.fans_count = fans_count;
    }
    @Column(name = "follow_count",length = 11,nullable = false)
    public int getFollow_count() {
        return follow_count;
    }

    public void setFollow_count(int follow_count) {
        this.follow_count = follow_count;
    }
    @Column(name = "letter_count",length = 11,nullable = false)
    public int getLetter_count() {
        return letter_count;
    }

    public void setLetter_count(int letter_count) {
        this.letter_count = letter_count;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", head='" + head + '\'' +
                ", description='" + description + '\'' +
                ", fans_count=" + fans_count +
                ", follow_count=" + follow_count +
                ", letter_count=" + letter_count +
                '}';
    }


}
