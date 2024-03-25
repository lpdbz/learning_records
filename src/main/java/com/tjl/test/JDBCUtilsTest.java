package com.tjl.test;

import com.tjl.bean.User;
import com.tjl.dao.UserDao_Imp;
import com.tjl.jdbc.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created with IntelliJ IDEA
 *
 * @Author : lkeren
 * @Date : 2024/03/21/16:59
 * @Description :
 */
public class JDBCUtilsTest {
    @Test
    public void jdbcConnectionTest() throws Exception{
        Connection conn = JDBCUtils.getConnection();
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery("select * from user");
        while (result.next()){
            System.out.print(result.getInt("id") + " ");
            System.out.print(result.getString("uname") + " ");
            System.out.print(result.getString("upass") + " ");
            System.out.println(result.getInt("type"));
        }
    }

    @Test
    public void login(){
        UserDao_Imp userDaoImp = new UserDao_Imp();
        User user = new User("liupei", "lp");
        int flag = userDaoImp.login(user);
        System.out.println(flag);
    }

    @Test
    // 测试修改用户
    public void insertTest(){
        UserDao_Imp userDaoImp = new UserDao_Imp();
        User user = new User("wangwu", "wangwu111");
        boolean flag = userDaoImp.update(user);
        System.out.println(flag);
    }

    @Test
    // 测试修改用户
    public void deleteTest(){
        UserDao_Imp userDaoImp = new UserDao_Imp();
        String name = "wangwu";
        boolean flag = userDaoImp.delete(name);
        System.out.println(flag);
    }

    @Test
    // 测试修改用户
    public void updateTest(){
        UserDao_Imp userDaoImp = new UserDao_Imp();
        User user = new User("wangwu", "wangwu111");
        boolean flag = userDaoImp.update(user);
        System.out.println(flag);
    }

    @Test
    // 测试修改用户
    public void selectTest(){
        UserDao_Imp userDaoImp = new UserDao_Imp();
        String name = "zhangsan";
        User user = userDaoImp.select("zhangsan");
        System.out.println(user);
    }
}