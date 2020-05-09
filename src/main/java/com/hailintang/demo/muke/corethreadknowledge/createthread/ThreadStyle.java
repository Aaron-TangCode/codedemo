package com.hailintang.demo.muke.corethreadknowledge.createthread;

/**
 * @author hailin.tang
 * @date 2020/5/1 12:39 上午
 * @function
 */
public class ThreadStyle extends Thread {
    @Override
    public void run() {
        System.out.println("i am thread");
    }

    public static void main(String[] args) {
        new ThreadStyle().start();
    }
}
