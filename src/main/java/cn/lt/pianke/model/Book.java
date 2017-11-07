package cn.lt.pianke.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by 刘婷 on 2017/6/14.
 */
@Table(name = "t_book")
public class Book {
    private Integer book_id;
    private String book_img;
    private String title;
    private String book_description;
    private String price;
    private String content_recommend;
    private String content_part;
    private String author_description;
    private String book_type;
    private Timestamp recommend_time;

    public Book() {
    }

    public Book(String book_img, String title, String book_description, String price, String content_recommend, String content_part, String author_description, String book_type, Timestamp recommend_time) {
        this.book_img = book_img;
        this.title = title;
        this.book_description = book_description;
        this.price = price;
        this.content_recommend = content_recommend;
        this.content_part = content_part;
        this.author_description = author_description;
        this.book_type = book_type;
        this.recommend_time = recommend_time;
    }

    //主键映射
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "book_id",length = 11,nullable = false)
    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }
    @Column(name = "book_img",nullable = false)
    public String getBook_img() {
        return book_img;
    }

    public void setBook_img(String book_img) {
        this.book_img = book_img;
    }
    @Column(name = "title",nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Column(name = "book_description",nullable = false)
    public String getBook_description() {
        return book_description;
    }

    public void setBook_description(String book_description) {
        this.book_description = book_description;
    }
    @Column(name = "price",nullable = false)
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    @Column(name = "content_recommend",nullable = false)
    public String getContent_recommend() {
        return content_recommend;
    }

    public void setContent_recommend(String content_recommend) {
        this.content_recommend = content_recommend;
    }
    @Column(name = "content_part",nullable = false)
    public String getContent_part() {
        return content_part;
    }

    public void setContent_part(String content_part) {
        this.content_part = content_part;
    }
    @Column(name = "author_description",nullable = false)
    public String getAuthor_description() {
        return author_description;
    }

    public void setAuthor_description(String author_description) {
        this.author_description = author_description;
    }
    @Column(name = "book_type",nullable = false)
    public String getBook_type() {
        return book_type;
    }

    public void setBook_type(String book_type) {
        this.book_type = book_type;
    }
    @Column(name = "recommend_time",nullable = false)
    public Timestamp getRecommend_time() {
        return recommend_time;
    }

    public void setRecommend_time(Timestamp recommend_time) {
        this.recommend_time = recommend_time;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", book_img='" + book_img + '\'' +
                ", title='" + title + '\'' +
                ", book_description='" + book_description + '\'' +
                ", price='" + price + '\'' +
                ", content_recommend='" + content_recommend + '\'' +
                ", content_part='" + content_part + '\'' +
                ", author_description='" + author_description + '\'' +
                ", book_type='" + book_type + '\'' +
                ", recommend_time=" + recommend_time +
                '}';
    }
}
