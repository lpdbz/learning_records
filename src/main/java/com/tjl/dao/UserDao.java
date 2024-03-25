package com.tjl.dao;

import com.tjl.bean.User;

/**
 * Created with IntelliJ IDEA
 *
 * @Author : lkeren
 * @Date : 2024/03/21/21:35
 * @Description :
 */
public interface UserDao {
    // 验证登录的方法
    int login( User user );

    /**
     * user要添加的对象，包含账户和密码
     * @param user
     * @return
     */
    boolean insert(User user);

    // 删除
    boolean delete(String uname);

    // 跟新
    boolean update(User user);

    // 用来查询学生信息的方法
    User select(String uname);
}
