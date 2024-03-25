package com.tjl.view;

import com.tjl.bean.User;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA
 *
 * @Author : lkeren
 * @Date : 2024/03/21/17:29
 * @Description :
 */

public class View {
   private static Scanner input = new Scanner(System.in);
    static String Indexuname;
    // 首页视图
    public static User indexView(){
        System.out.println("************************************");
        System.out.println("*******\t\t学生信息管理系统\t\t*******");
        System.out.println("*******\t\t请根据提示操作\t\t*******");
        System.out.println("*******\t\t请输入账号：\t\t*******");
        Indexuname = input.nextLine();
        System.out.println("*******\t\t请输入密码：\t\t*******");
        String upass = input.nextLine();
        System.out.println("************************************");
        return new User(Indexuname, upass);
    }

    // 用户视图
    public static int UserMenuView(){
        System.out.println("************************************");
        System.out.println("*******\t\t欢迎学生回家\t\t*******");
        System.out.println("*******\t\t请根据提示操作\t\t*******");
        System.out.println("*******\t\t0.退出：\t\t*******");
        System.out.println("*******\t\t1.修改个人信息\t\t*******");
        System.out.println("*******\t\t2.查找个人信息\t\t*******");

        String type = input.nextLine();
        // 将获取到的数据转换为int类型
        int item = Integer.parseInt(type);
        if( item<0 || item>4){
            System.out.println("输入错误，请重新输入");
            return UserMenuView();
        }
        System.out.println("************************************");
        return item;
    }

    // 管理员视图
    public static int ManagerMenuView(){
        System.out.println("************************************");
        System.out.println("*******\t\t欢迎管理员回家\t\t*******");
        System.out.println("*******\t\t请根据提示操作\t\t*******");
        System.out.println("*******\t\t0.退出：\t\t*******");
        System.out.println("*******\t\t1.添加学生信息\t\t*******");
        System.out.println("*******\t\t2.删除学生信息\t\t*******");
        System.out.println("*******\t\t3.修改学生信息\t\t*******");
        System.out.println("*******\t\t4.查找学生信息\t\t*******");

        String type = input.nextLine();
        // 将获取到的数据转换为int类型
        int item = Integer.parseInt(type);
        if( item<0 || item>4){
            System.out.println("输入错误，请重新输入");
            return ManagerMenuView();
        }
        System.out.println("************************************");
        return item;
    }

    // 添加学生信息视图
    public static User addMenuView(){
        System.out.println("************************************");
        System.out.println("*******\t\t请根据提示操作\t\t*******");
        System.out.println("*******\t\t请输入账号：\t\t*******");
        String uname = input.nextLine();
        System.out.println("*******\t\t请输入密码：\t\t*******");
        String upass = input.nextLine();
        System.out.println("************************************");
        return new User(uname, upass);
    }

    public static String deleteMenuView(){
        System.out.println("************************************");
        System.out.println("*******\t\t请根据提示操作\t\t*******");
        System.out.println("*******\t\t请输入账号：\t\t*******");
        String uname = input.nextLine();
        System.out.println("************************************");
        return uname;
    }

    public static User updateMenuView(){
        System.out.println("************************************");
        System.out.println("*******\t\t请根据提示操作\t\t*******");
        System.out.println("*******\t\t请输入账号：\t\t*******");
        String uname = input.nextLine();
        System.out.println("*******\t\t请输入新密码：\t\t*******");
        String upass = input.nextLine();
        System.out.println("************************************");
        return new User(uname, upass);
    }

    public static String selectMenuView(){
        System.out.println("************************************");
        System.out.println("*******\t\t请根据提示操作\t\t*******");
        System.out.println("*******\t\t请输入账号：\t\t*******");
        String uname = input.nextLine();
        System.out.println("************************************");
        return uname;
    }

    //用户修改个人信息
    public static User updateUserMenuView(){
        System.out.println("************************************");
        System.out.println("*******\t\t请根据提示操作\t\t*******");
        System.out.println("*******\t\t请输入新密码：\t\t*******");
        String upass = input.nextLine();
        System.out.println("************************************");
        return new User(Indexuname,upass);
    }

    public static void printUser( User user){
        System.out.println("用户的ID:" + user.getId());
        System.out.println("用户的姓名:" + user.getUname());
        System.out.println("用户的密码:" + user.getUpass());
        if(user.getType() == 1){
            System.out.println("用户的权限:管理员");
        }else {
            System.out.println("用户的权限:学生");
        }

    }
}
