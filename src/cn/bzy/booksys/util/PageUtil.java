package cn.bzy.booksys.util;

/**
 * @author zhenyiBi
 * @date 2022/7/15
 */
public class PageUtil {

    public static void home(){
        System.out.println("**************{欢迎进入图书馆}******************");
        System.out.println("请选择您的身份");
        System.out.println("1：读者");
        System.out.println("2：管理员");
        System.out.println("0：退出系统");
        System.out.print("请输入：");
    }

    public static void reader(){
        System.out.println("*************{欢迎进入读者功能}*****************");
        System.out.println("1：查看图书");
        System.out.println("2：借阅图书");
        System.out.println("3：归还图书");
        System.out.println("4：查询已借阅图书");
        System.out.println("0：返回上层");
        System.out.print("请输入：");
    }

    public static void readerQuery(){
        System.out.println("*************{选择查询功能}*****************");
        System.out.println("1：显示所有图书");
        System.out.println("2：根据名称查询");
        System.out.println("0：返回上层");
        System.out.print("请输入：");
    }

    public static void admin() {
        System.out.println("*************{欢迎进入管理员功能}*****************");
        System.out.println("1：查看图书");
        System.out.println("2：添加图书");
        System.out.println("3：修改图书");
        System.out.println("4：删除图书");
        System.out.println("5：查询已借阅图书");
        System.out.println("0：返回上层");
        System.out.print("请输入：");
    }

    public static void updateBook() {
        System.out.println("*************{欢迎进入图书修改功能}*****************");
        System.out.println("1：修改图书名称");
        System.out.println("2：修改图书作者");
        System.out.println("3：修改图书库存");
        System.out.print("请输入：");
    }
}
