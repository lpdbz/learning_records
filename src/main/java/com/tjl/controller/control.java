package com.tjl.controller;

import com.tjl.bean.User;
import com.tjl.dao.UserDao_Imp;
import com.tjl.utils.Utils;
import com.tjl.view.View;

/**
 * Created with IntelliJ IDEA
 *
 * @Author : lkeren
 * @Date : 2024/03/25/9:57
 * @Description :
 */
public class control {
    public static void main(String[] args) {
        while(true){
            User user = View.indexView();
            UserDao_Imp userDaoImp = new UserDao_Imp();
            int type = userDaoImp.login(user);
            switch (type){
                case -1:
                    System.out.println("输入有误，请重新输入");
                    break;
                case 1:
                    managerServer();
                    break;
                case 2:
                    userServer();
                    break;
            }
        }
    }

    private static void userServer() {
        UserDao_Imp userDaoImp = new UserDao_Imp();
        Utils utils = new Utils();
        while(true){
            int item = View.UserMenuView();
            boolean flag;
            switch ( item ){
                case 0:
                    System.exit(-1);
                    break;
                case 1:
                    utils.clearConsole();
                    User user = View.updateUserMenuView();
                    flag = userDaoImp.update(user);
                    System.out.println(flag?"修改成功":"修改失败");
                    break;
                case 2:
                    utils.clearConsole();
                    String uname = View.selectMenuView();
                    User selectUser = userDaoImp.select(uname);
                    if(selectUser != null){
                        View.printUser(selectUser);
                    }else {
                        System.out.println("抱歉，没有该学生信息");
                    }
                    break;
            }
        }
    }

    private static void managerServer() {
        UserDao_Imp userDaoImp = new UserDao_Imp();
        Utils utils = new Utils();
        while(true){
            int item = View.ManagerMenuView();
            boolean flag;
            switch( item ){
                case 0:
                    System.exit(-1);
                    break;
                case 1:
                    utils.clearConsole();
                    User addUser = View.addMenuView();
                    flag = userDaoImp.insert(addUser);
                    System.out.println(flag?"添加成功" : "添加失败");
                    break;
                case 2:
                    utils.clearConsole();
                    String name = View.deleteMenuView();
                    flag = userDaoImp.delete(name);
                    System.out.println(flag?"删除成功" : "删除失败");
                    break;
                case 3:
                    utils.clearConsole();
                    User updateUser = View.updateMenuView();
                    flag = userDaoImp.update(updateUser);
                    System.out.println(flag?"修改成功" : "修改失败");
                    break;
                case 4:
                    utils.clearConsole();
                    String uname = View.selectMenuView();
                    User selectUser = userDaoImp.select(uname);
                    if(selectUser != null){
                        View.printUser(selectUser);
                    }else {
                        System.out.println("抱歉，没有该学生信息");
                    }
                    break;
            }
        }
    }
}
