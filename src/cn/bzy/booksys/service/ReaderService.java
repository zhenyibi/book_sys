package cn.bzy.booksys.service;

import cn.bzy.booksys.dto.SysDTO;
import cn.bzy.booksys.entity.Book;
import cn.bzy.booksys.util.BookSysUtil;
import cn.bzy.booksys.util.PageUtil;

import java.util.Arrays;

/**
 * @author zhenyiBi
 * @date 2022/7/15
 */
public class ReaderService {
    public void readFunction(SysDTO sysDTO) {

        PageUtil.reader();
        String readerType = BookSysUtil.inputValue(Arrays.asList("0", "1", "2", "3", "4"));
        switch (readerType){
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
                break;
            case "4":
                //查看已借阅图书
                break;
            case "0":
                //返回上一层
                sysDTO.getBookSysMain().home(sysDTO);
                break;
            default:
                break;
        }
        if ("1" == readerType) {
            PageUtil.readerQuery();
            String queryType = BookSysUtil.inputValue(Arrays.asList("0", "1", "2"));
        }
    }

    private void lookSysBookList(SysDTO sysDTO) {
        System.out.println("*****************************************");
        System.out.println("书名          作者          库存          价格");
        if(sysDTO.getBookSysMain().bookDB.size() == 0){
            System.out.println("暂无书籍");
            return;
        }
        for (Book book : sysDTO.getBookSysMain().bookDB) {
            System.out.println(book.getName()+"          "+book.getAuthor()+"          "+book.getStock()+"          "+book.getPrice());
        }
        System.out.println("*****************************************");
    }

    private void borrowBook(SysDTO sysDTO) {
        /**
         * 从库存集合中减少一个，借阅集合中增加一个
         */
        
    }

}
