package cn.bzy.booksys.service;

import cn.bzy.booksys.dto.SysDTO;
import cn.bzy.booksys.entity.Book;
import cn.bzy.booksys.util.BookSysUtil;
import cn.bzy.booksys.util.PageUtil;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author zhenyiBi
 * @date 2022/7/15
 */
public class ReaderService {
    public void readFunction(SysDTO sysDTO) {

        PageUtil.reader();
        String readerType = BookSysUtil.inputValue(Arrays.asList("0", "1", "2", "3", "4"));
        switch (readerType) {
            case "1":
                //查看图书
                lookSysBookList(sysDTO);
                break;
            case "2":
                //借阅图书
                borrowBook(sysDTO);
                break;
            case "3":
                //归还图书
                remandBorrowBook(sysDTO);
                break;
            case "4":
                //查看已借阅图书
                lookBorrowBook(sysDTO);
                break;
            case "0":
                //返回上一层
                sysDTO.getHomeService().home(sysDTO);
                break;
            default:
                break;
        }
        readFunction(sysDTO);

    }

    private void remandBorrowBook(SysDTO sysDTO) {
        /**
         * 1 输入归还的书名
         * 2 判断借阅列表是否存在书名
         * 3 存在，借阅列表对应书籍减1，库存列表对应书籍加1
         * 4 不存在，提示”该书未借阅！“
         */
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入归还的书名：");
        String bookName = scanner.nextLine();

        Book book = BookSysUtil.getBook(sysDTO.getBookDB().borrowBookDB, bookName);
        if (Objects.isNull(book)) {
            System.out.println("没借过这本书！");
            return;
        }
        book.setStock(book.getStock() - 1);
        Book book_ = BookSysUtil.getBook(sysDTO.getBookDB().bookDB, bookName);
        book_.setStock(book_.getStock() + 1);

        if (book.getStock() == 0) {
            BookSysUtil.removeBook(sysDTO, bookName);
        }
        System.out.println("归还成功!");


    }

    private void lookBorrowBook(SysDTO sysDTO) {
        System.out.println("***************借阅列表**********************");
        System.out.println("书名          作者          库存          价格");
        if (sysDTO.getBookDB().borrowBookDB.size() == 0) {
            System.out.println("暂无书籍");
            return;
        }
        for (Book book : sysDTO.getBookDB().borrowBookDB) {
            System.out.println(book.getName() + "          " + book.getAuthor() + "          " + book.getStock() + "          " + book.getPrice());
        }
        System.out.println("********************************************");
    }

    private void lookSysBookList(SysDTO sysDTO) {
        System.out.println("***************库存列表**********************");
        System.out.println("书名          作者          库存          价格");
        if (sysDTO.getBookDB().bookDB.size() == 0) {
            System.out.println("暂无书籍");
            return;
        }
        for (Book book : sysDTO.getBookDB().bookDB) {
            System.out.println(book.getName() + "          " + book.getAuthor() + "          " + book.getStock() + "          " + book.getPrice());
        }
        System.out.println("*****************************************");
    }

    private void borrowBook(SysDTO sysDTO) {
        /**
         * 从库存集合中减少一个，借阅集合中增加一个
         */
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入要借阅的书名:");
        String bookName = scanner.nextLine();
        Boolean bookExist = Boolean.FALSE;
        for (Book book : sysDTO.getBookDB().bookDB) {
            if (book.getName().equals(bookName)) {
                bookExist = Boolean.TRUE;
                Boolean borrowedExist = Boolean.FALSE;
                for (Book borrowBook : sysDTO.getBookDB().borrowBookDB) {
                    if (borrowBook.getName().equals(bookName)) {
                        borrowedExist = Boolean.TRUE;
                        borrowBook.setStock(borrowBook.getStock() + 1);
                        book.setStock(book.getStock() - 1);
                        break;
                    }
                }
                if (borrowedExist) {
                    break;
                }
                Book book_ = new Book();
                book_.setName(bookName);
                book_.setAuthor(book.getAuthor());
                book_.setPrice(book.getPrice());
                book_.setStock(1);
                //减库存
                book.setStock(book.getStock() - 1);
                sysDTO.getBookDB().borrowBookDB.add(book_);

            }

        }
        if (!bookExist) {
            System.out.println("此图书不存在！");
        } else {
            System.out.println("借阅成功！");
        }


    }

}
