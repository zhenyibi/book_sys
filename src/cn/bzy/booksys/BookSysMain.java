package cn.bzy.booksys;

import cn.bzy.booksys.util.BookSysUtil;
import cn.bzy.booksys.util.PageUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhenyiBi
 * @date 2022/7/15
 */
public class BookSysMain {

    public static void main(String[] args) {

        PageUtil.home();
        String typeValue = BookSysUtil.inputValue(Arrays.asList("0", "1", "2"));

        if("0" == typeValue){
            bookSysExit();
        }

        if("1" == typeValue){
            PageUtil.reader();
            String readerTypeValue = BookSysUtil.inputValue(Arrays.asList("0", "1", "2", "3", "4"));
            if("0" == readerTypeValue){
                PageUtil.readerQuery();
                String queryType = BookSysUtil.inputValue(Arrays.asList("0", "1", "2"));
            }
        }

        if("2" == typeValue){
            System.out.println("2");
        }


    }

    private static void bookSysExit() {
        System.exit(0);
    }
}
