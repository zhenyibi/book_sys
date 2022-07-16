package cn.bzy.booksys;

import cn.bzy.booksys.dto.SysDTO;
import cn.bzy.booksys.entity.Book;
import cn.bzy.booksys.service.AdminService;
import cn.bzy.booksys.service.HomeService;
import cn.bzy.booksys.service.ReaderService;
import cn.bzy.booksys.util.BookDB;
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

    public static void main(String[] args) {

        SysDTO sysDTO = new SysDTO();
        sysDTO.setBookDB(new BookDB());
        sysDTO.setHomeService(new HomeService());
        sysDTO.setAdminService(new AdminService());
        sysDTO.setReaderService(new ReaderService());

        //首页功能
        sysDTO.getHomeService().home(sysDTO);

    }




}
