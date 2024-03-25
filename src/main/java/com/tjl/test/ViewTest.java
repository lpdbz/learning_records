package com.tjl.test;

import com.tjl.bean.User;
import com.tjl.view.View;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA
 *
 * @Author : lkeren
 * @Date : 2024/03/21/20:18
 * @Description :
 */
public class ViewTest {
    @Test
    // 测试登录页
    public void indexViewTest() throws Exception{
        User user1 = View.indexView();
        System.out.println(user1);
    }

    @Test
    // 测试管理员菜单视图
    public void managerMenuViewTest() throws Exception {
        int item = View.ManagerMenuView();
        System.out.println(item);
    }

    @Test
    // 测试添加学生信息视图
    public void addMenuViewTest() throws Exception{
        User user = View.addMenuView();
        System.out.println(user);
    }
}
