package com.tjl.utils;
import java.awt.*;
import java.awt.event.KeyEvent;
/**
 * Created with IntelliJ IDEA
 *
 * @Author : lkeren
 * @Date : 2024/03/25/12:13
 * @Description :
 */
public class Utils {
    public void clearConsole(){
        System.out.println(new String(new char[50]).replace("\0", "\r\n"));
    }
}


