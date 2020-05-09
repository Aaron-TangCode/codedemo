package com.hailintang.demo.muke.corethreadknowledge.startthread;

/**
 * @author hailin.tang
 * @date 2020/5/3 12:55 下午
 * @function
 */
public class StartAndRunMethod {
    public static void main(String[] args) {
        Runnable runnable = () ->{
            System.out.println(Thread.currentThread().getName());
        };

        runnable.run();

        new Thread(runnable).start();
    }
}
