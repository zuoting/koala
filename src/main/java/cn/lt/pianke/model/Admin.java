package cn.lt.pianke.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by 刘婷 on 2017/6/19.
 */
@Table(name="t_admin")
public class Admin {
    private  Integer admin_id;
    private String username;
    private String password;
    private String head;
    private Timestamp created_at;
    private Timestamp updated_at;

    public Admin() {
    }

    public Admin(String username, String password, String head, Timestamp created_at, Timestamp updated_at) {
        this.username = username;
        this.password = password;
        this.head = head;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "admin_id",nullable = false)
    public Integer getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Integer admin_id) {
        this.admin_id = admin_id;
    }
    @Column(name = "username",nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Column(name = "password",nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Column(name = "head",nullable = false)
    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }



    @Column(name = "created_at",nullable = false)
    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
    @Column(name = "updated_at",nullable = false)
    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "admin_id=" + admin_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", head='" + head + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
