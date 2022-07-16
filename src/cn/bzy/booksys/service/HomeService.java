package cn.bzy.booksys.service;

import cn.bzy.booksys.dto.SysDTO;
import cn.bzy.booksys.util.BookSysUtil;
import cn.bzy.booksys.util.PageUtil;

import java.util.Arrays;

/**
 * @author zhenyiBi
 * @date 2022/7/15
 */
public class HomeService implements FunctionService{

    @Override
    public void function(SysDTO sysDTO) {
        PageUtil.home();
        String typeValue = BookSysUtil.inputValue(Arrays.asList("0", "1", "2"));
        switch (typeValue) {
            case "1":
                //读者
                sysDTO.getReaderService().function(sysDTO);
                break;
            case "2":
                //管理员
                sysDTO.getAdminService().function(sysDTO);
                break;
            case "0":
                //退出
                BookSysUtil.bookSysExit();
                break;
        }

    }

}
