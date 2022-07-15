package cn.bzy.booksys.util;

import java.util.List;
import java.util.Scanner;

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
}
