package cn.bzy.booksys.util;

import cn.bzy.booksys.dto.SysDTO;
import cn.bzy.booksys.entity.Book;

import java.util.*;

/**
 * @author zhenyiBi
 * @date 2022/7/15
 */
public class BookSysUtil {


    public static String inputValue(List<String> userTypeValueList) {

        Scanner scanner = new Scanner(System.in);
        String typeValue = scanner.nextLine();
        while(true){
            if(!userTypeValueList.contains(typeValue)){
                System.out.println("输入非法，请重新输入！");
                System.out.print("请输入：");
                typeValue = scanner.nextLine();
            }else{
                break;
            }
        }
        return typeValue;
    }

    public static void bookSysExit() {
        System.exit(0);
    }

    public static Book getBook(List<Book> bookList, String bookName) {
        if(Objects.isNull(bookName)){
            return null;
        }
        for (Book book : bookList) {
            if(book.getName().equals(bookName)){
                return book;
            }
        }
        return null;
    }

    public static void removeBook(SysDTO sysDTO, String bookName) {
        Iterator<Book> iterator = sysDTO.getBookSysMain().borrowBookDB.iterator();
        while(iterator.hasNext()){
            if(iterator.next().getName().equals(bookName)){
                iterator.remove();
            }
        }


//        //方法一：
//        List<Book> newBookDB = new ArrayList<>();
//        for (Book book : sysDTO.getBookSysMain().borrowBookDB) {
//            if(!book.getName().equals(bookName)){{
//                newBookDB.add(book);
//            }}
//        }
//        sysDTO.getBookSysMain().borrowBookDB = newBookDB;
    }
}
