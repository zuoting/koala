package cn.lt.pianke.web;

import cn.lt.pianke.model.Book;
import cn.lt.pianke.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 刘婷 on 2017/6/14.
 */
@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    /**
     * 获取所有作者
     *
     * @return List<User>所有作者
     */
    @RequestMapping(value = "allBooks", method = RequestMethod.GET)
    public ResponseEntity<List<Book>> listAllAuthors() {
        List<Book> books = bookService.getBooks();
        if (books.isEmpty()) {
            return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
    }

    /**
     * 根据书id查询单个实体
     * @param book_id
     * @return
     */
    @RequestMapping(value = "books/{book_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> findBook(@PathVariable("book_id") int book_id) {
        Book book = bookService.findBookById(book_id);
        if (book == null) {
            System.out.println(" not found");
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

//后台管理
    /**
     * 后台管理 根据id删除一个文章
     *
     * @param book_id
     * @return
     */
    @RequestMapping(value = "admin/deleteBooks/{book_id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteBook(@PathVariable int book_id) {
        Book book =  bookService.findBookById(book_id);
        if (book == null) {
            System.out.println("not found");
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        bookService.deleteBookById(book_id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
