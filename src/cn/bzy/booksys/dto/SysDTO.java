package cn.bzy.booksys.dto;

import cn.bzy.booksys.BookSysMain;
import cn.bzy.booksys.service.AdminService;
import cn.bzy.booksys.service.HomeService;
import cn.bzy.booksys.service.ReaderService;
import cn.bzy.booksys.util.BookDB;

/**
 * @author zhenyiBi
 * @date 2022/7/16
 */
public class SysDTO {

    private BookDB bookDB;
    HomeService homeService;
    ReaderService readerService;
    AdminService adminService;

    public ReaderService getReaderService() {
        return readerService;
    }

    public void setReaderService(ReaderService readerService) {
        this.readerService = readerService;
    }

    public AdminService getAdminService() {
        return adminService;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    public HomeService getHomeService() {
        return homeService;
    }

    public void setHomeService(HomeService homeService) {
        this.homeService = homeService;
    }

    public BookDB getBookDB() {
        return bookDB;
    }

    public void setBookDB(BookDB bookDB) {
        this.bookDB = bookDB;
    }

}
