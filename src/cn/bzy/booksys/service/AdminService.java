package cn.bzy.booksys.service;

import cn.bzy.booksys.dto.SysDTO;
import cn.bzy.booksys.entity.Book;
import cn.bzy.booksys.util.BookSysUtil;
import cn.bzy.booksys.util.PageUtil;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author zhenyiBi
 * @date 2022/7/15
 */
public class AdminService {
    public void adminFunction(SysDTO sysDTO) {
        PageUtil.admin();
        String type = BookSysUtil.inputValue(Arrays.asList("0", "1", "2", "3", "4", "5"));

        switch (type) {
            case "1":
                //查看图书
                lookSysBookList(sysDTO);
                break;
            case "2":
                //添加图书
                addSysBook(sysDTO);
                break;
            case "3":
                //修改图书
                updateSysBook(sysDTO);
                break;
            case "4":
                //删除图书
                deleteSysBook(sysDTO);
                break;
            case "5":
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
        adminFunction(sysDTO);
    }

    private void deleteSysBook(SysDTO sysDTO) {
        /**
         * 1 先输入要删除的书名
         * 2 判断书名是否存在
         * 3 判断是否借出
         * 4 借出的无法删除
         */

        System.out.print("请输入要删除的书名:");
        Scanner scanner = new Scanner(System.in);
        String bookName = scanner.nextLine();
        //判断书籍是否存在
        Boolean exist = Boolean.FALSE;
        for (Book book : sysDTO.getBookDB().bookDB) {
            if(book.getName().equals(bookName)){
                exist = Boolean.TRUE;
            }
        }
        if(!exist){
            System.out.println("此书籍不存在,无需删除!");
            return;
        }

        //判断书籍是否借出
        Boolean borrowExist = Boolean.FALSE;
        for (Book book : sysDTO.getBookDB().borrowBookDB) {
            if(book.getName().equals(bookName)){
                borrowExist = Boolean.TRUE;
            }
        }
        if(borrowExist){
            System.out.println("此书籍被借阅,无法删除!");
            return;
        }

        //删除库存列表书籍
        Iterator<Book> iterator = sysDTO.getBookDB().bookDB.iterator();
        while(iterator.hasNext()){
            if(iterator.next().getName().equals(bookName)){
                iterator.remove();
            }
        }
        System.out.println("图书删除成功!");

    }

    private void updateSysBook(SysDTO sysDTO) {
        System.out.print("请输入要修改的书名:");
        Scanner scanner = new Scanner(System.in);
        String bookName = scanner.nextLine();
        Boolean exist = Boolean.FALSE;
        Book oldBook = null;
        for (Book book : sysDTO.getBookDB().bookDB) {
            if(book.getName().equals(bookName)){
                exist = Boolean.TRUE;
                oldBook = book;
            }
        }
        if(!exist){
            System.out.println("此书籍不存在,无需修改!");
            return;
        }

        PageUtil.updateBook();
        String updateType = BookSysUtil.inputValue(Arrays.asList("1", "2", "3"));
        switch (updateType){
            case "1":
                //修改图书名称
                System.out.println("请输入新书名:");
                String newBookName = scanner.nextLine();
                oldBook.setName(newBookName);
                break;
            case "2":
                //修改图书作者
                System.out.println("请输入新作者:");
                String newBookAuthor = scanner.nextLine();
                oldBook.setAuthor(newBookAuthor);
                break;
            case "3":
                //修改图书库存
                System.out.println("请输入新库存:");
                Integer newBookStock = Integer.valueOf(scanner.nextLine());
                oldBook.setStock(newBookStock);
                break;
            default:
                break;
        }
        System.out.println("图书修改成功!");

    }

    private void addSysBook(SysDTO sysDTO) {
        /***
         * 1 获得库存集合
         * 2 生成book信息
         * 3 将book存入集合,完成库存添加
         */
        Scanner scanner = new Scanner(System.in);
        Book book = new Book();
        System.out.print("请输入图书名称:");
        book.setName(scanner.nextLine());
        System.out.print("请输入图书作者:");
        book.setAuthor(scanner.nextLine());
        System.out.print("请输入图书库存:");
        book.setStock(Integer.valueOf(scanner.nextLine()));
        System.out.print("请输入图书价格:");
        book.setPrice(Double.parseDouble(scanner.nextLine()));

        //判断库存中是否有相同书籍
        for (Book book1 : sysDTO.getBookDB().bookDB) {
            if (book1.getName().equals(book.getName())) {
                book1.setStock(book1.getStock() + book.getStock());
                System.out.println("图书添加成功!");
                return;
            }
        }
        sysDTO.getBookDB().bookDB.add(book);
        System.out.println("图书添加成功!");

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
}
