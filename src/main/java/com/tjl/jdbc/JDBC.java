package com.tjl.jdbc;

import java.sql.*;

/**
 * Created with IntelliJ IDEA
 *
 * @Author : lkeren
 * @Date : 2024/03/21/15:44
 * @Description :
 */
public class JDBC {
    public static void main(String[] args) {
        // 加载JDBC的驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // 1
            System.out.println("驱动加载成功");

            // 连接数据库  // 2
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "root", "root");
            System.out.println("数据库连接成功");

            // 创建执行环境  // 3
            Statement statement = conn.createStatement();

            // 执行sql语句，得到结果集  // 4
            String sql = "select * from user";
            ResultSet result = statement.executeQuery(sql);  // 5
            while (result.next()){
                System.out.print(result.getInt("id") + " ");
                System.out.print(result.getString("uname") + " ");
                System.out.print(result.getString("upass") + " ");
                System.out.println(result.getInt("type") + " ");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("驱动加载失败");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.out.println("数据库连接失败");
            throw new RuntimeException(e);
        }
    }
}
