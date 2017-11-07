package cn.lt.pianke.service.impl;

import cn.lt.pianke.dao.BookDAO;
import cn.lt.pianke.model.Book;
import cn.lt.pianke.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by 刘婷 on 2017/6/14.
 */
@Service
@Transactional
public class BookServiceImpl implements BookService{
    @Autowired
    private BookDAO bookDAO;
    /**
     * 查询所有书籍
     *
     * @return List<Book>
     */
    @Override
    public List<Book> getBooks() {
        return bookDAO.selectAll();
    }

    /**
     * 根据id查询单个实体
     *
     * @param book_id
     * @return
     */
    @Override
    public Book findBookById(int book_id) {
    Example example=new Example(Book.class);
    example.createCriteria()
            .andEqualTo("book_id",book_id);
    return bookDAO.selectByExample(example).get(0);
    }


//后台管理
    /**
     * 后台管理 根据id删除一本书籍
     *
     * @param book_id
     * @return
     */
    @Override
    public void deleteBookById(int book_id) {
        Example example =new Example(Book.class);
        example.createCriteria()
                .andEqualTo("book_id",book_id);
        bookDAO.deleteByExample(example);
    }

}
