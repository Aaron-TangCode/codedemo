package com.hailintang.demo.muke.juctool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author hailin.tang
 * @date 2020/6/9 6:10 下午
 * @function 1000个线程,吧SimpleDateFormat独立成一个
 */
public class TestThreadLocal02 {
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i=0;i<1000;i++){
            final int k = i;
            executorService.submit(()->{
                printDate(k);
            });
        }
        executorService.shutdown();
    }
    public static void printDate(int seconds){
        Date date = new Date(1000*seconds);
        String format1 = format.format(date);
        System.out.println(format1);
    }
}
