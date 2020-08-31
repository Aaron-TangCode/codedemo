package com.hailintang.demo.muke.juctool;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author hailin.tang
 * @date 2020/6/9 6:10 下午
 * @function 两个线程
 */
public class TestThreadLocal00 {
    public static void main(String[] args) {
        new Thread(()->{
            printDate(1);
        }).start();
        new Thread(()->{
            printDate(1000);
        }).start();
    }
    public static void printDate(int seconds){
        Date date = new Date(1000*seconds);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format1 = format.format(date);
        System.out.println(format1);
    }
}
