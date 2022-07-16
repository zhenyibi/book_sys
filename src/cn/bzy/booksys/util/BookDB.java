package cn.bzy.booksys.util;

import cn.bzy.booksys.entity.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhenyiBi
 * @date 2022/7/16
 */
public class BookDB {
    /**
     * 图书数据库（库存集合）
     */
    public List<Book> bookDB = new ArrayList<>();

    {
        Book book = new Book();
        book.setName("西游记");
        book.setAuthor("吴承恩");
        book.setPrice(100.0);
        book.setStock(100);
        bookDB.add(book);
    }


    /**
     * 图书数据库（借阅集合）
     */
    public List<Book> borrowBookDB = new ArrayList<>();
}
