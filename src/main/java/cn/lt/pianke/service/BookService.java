package cn.lt.pianke.service;

import cn.lt.pianke.model.Book;

import java.util.List;

/**
 * Created by 刘婷 on 2017/6/14.
 */
public interface BookService {
    /**
     * 查询所有书籍
     *
     * @return List<Book>
     */
    List<Book> getBooks();

    /**
     * 根据id查询单个实体
     * @param book_id
     * @return
     */
     Book findBookById(int book_id);

    /**
     * 后台管理 根据id删除一本书籍
     * @param book_id
     * @return
     */
    void deleteBookById(int book_id);       //根据id删除一个实体


}
