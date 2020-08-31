package com.hailintang.demo.muke.corethreadknowledge.oddeven;

/**
 * @author hailin.tang
 * @date 2020/5/18 9:07 下午
 * @function
 */
public class OddEven {
    public static Object lock = new Object();
    static int i = 0;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (i < 100) {
                    synchronized (lock) {
                        if ((i & 1) == 1) {
                            System.out.println(Thread.currentThread().getName() + ":" + i++);
                        }
                    }
                }
            }
        }, "单数").start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                while (i < 100) {
                    synchronized (lock) {
                        if ((i & 1) == 0) {
                            System.out.println(Thread.currentThread().getName() + ":" + i++);
                        }

                    }
                }
            }
        }, "双数").start();
    }
}
