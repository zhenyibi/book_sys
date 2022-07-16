package cn.bzy.booksys;

import cn.bzy.booksys.dto.SysDTO;
import cn.bzy.booksys.entity.Book;
import cn.bzy.booksys.service.AdminService;
import cn.bzy.booksys.service.ReaderService;
import cn.bzy.booksys.util.BookSysUtil;
import cn.bzy.booksys.util.PageUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhenyiBi
 * @date 2022/7/15
 */
public class BookSysMain {

    ReaderService readerService = new ReaderService();
    AdminService adminService = new AdminService();
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

    public static void main(String[] args) {

        SysDTO sysDTO = new SysDTO();
        sysDTO.setBookSysMain(new BookSysMain());
        sysDTO.getBookSysMain().home(sysDTO);

    }

    public void home(SysDTO sysDTO){
        PageUtil.home();
        String typeValue = BookSysUtil.inputValue(Arrays.asList("0", "1", "2"));
        switch (typeValue){
            case "1":
                //读者
                readerService.readFunction(sysDTO);
                break;
            case "2":
                //管理员
                adminService.adminFunction(sysDTO);
                break;
            case "0":
                //退出
                BookSysUtil.bookSysExit();
                break;
        }


        if ("1".equals(typeValue) ) {

        }

        if ("2" == typeValue) {
            System.out.println("2");
        }
    }


}
