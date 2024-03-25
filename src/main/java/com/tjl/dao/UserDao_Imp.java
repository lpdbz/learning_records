package com.tjl.dao;

import com.tjl.bean.User;
import com.tjl.jdbc.JDBCUtils;

import java.sql.*;

/**
 * Created with IntelliJ IDEA
 *
 * @Author : lkeren
 * @Date : 2024/03/21/21:54
 * @Description :
 */
public class UserDao_Imp implements UserDao {
    private static final String SQL_USER_LOGIN = "select type from user where uname=? and upass=?";
    private static final String SQL_USER_INSERT = "INSERT INTO user VALUES(id, ?, ?, 2)";
    private static final String SQL_USER_DELETE = "DELETE FROM `user` WHERE uname = ?";

    private static final String SQL_USER_UPDATE = "UPDATE `user` SET upass = ? where uname = ?";

    private static final String SQL_USER_SELECT = "SELECT * FROM `user` where uname = ?";
    @Override
    public int login(User user) {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            preparedStatement = conn.prepareStatement(SQL_USER_LOGIN);
            // 设置sql语句中的参数
            preparedStatement.setString(1, user.getUname());
            preparedStatement.setString(2, user.getUpass());
            result = preparedStatement.executeQuery();

            while (result.next()) {
                int type = result.getInt("type");
                return type;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(conn, preparedStatement, result);
        }
        return -1;
    }

    @Override
    public boolean insert(User user) {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(SQL_USER_INSERT);
            preparedStatement.setString(1, user.getUname());
            preparedStatement.setString(2, user.getUpass());
            int flag = preparedStatement.executeUpdate();
            return flag > 0 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(conn, preparedStatement, null);
        }
    }

    @Override
    public boolean delete(String uname) {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(SQL_USER_DELETE);
            preparedStatement.setString(1, uname);
            int flag = preparedStatement.executeUpdate();
            return flag > 0 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(conn, preparedStatement, null);
        }
    }

    @Override
    public boolean update(User user) {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(SQL_USER_UPDATE);
            preparedStatement.setString(1, user.getUpass());
            preparedStatement.setString(2, user.getUname());
            int flag = preparedStatement.executeUpdate();
            return flag > 0 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(conn, preparedStatement, null);
        }
    }

    @Override
    public User select(String uname) {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(SQL_USER_SELECT);
            preparedStatement.setString(1, uname);
            ResultSet result = preparedStatement.executeQuery();
            while(result.next()){
                int id = result.getInt("id");
                String uname1 = result.getString("uname");
                String upass = result.getString("upass");
                int type = result.getInt("type");
                return new User(id, uname1, upass, type);
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(conn, preparedStatement, null);
        }
    }
}
