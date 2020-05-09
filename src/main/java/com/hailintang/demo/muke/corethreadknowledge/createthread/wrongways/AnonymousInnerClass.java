package com.hailintang.demo.muke.corethreadknowledge.createthread.wrongways;

/**
 * @author hailin.tang
 * @date 2020/5/1 1:11 上午
 * @function 本质创建方法就是runnable或thread
 */
public class AnonymousInnerClass {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
    }
}
