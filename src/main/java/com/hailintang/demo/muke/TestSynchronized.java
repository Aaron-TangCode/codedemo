package com.hailintang.demo.muke;

/**
 * @author hailin.tang
 * @date 2020/4/20 9:18 下午
 * @function
 */
public class TestSynchronized implements Runnable{
    static TestSynchronized testSynchronized = new TestSynchronized();
    Object lock1 = new Object();
    Object lock2 = new Object();
    public static void main(String[] args) {
        Thread t1 = new Thread(testSynchronized);
        Thread t2 = new Thread(testSynchronized);
        t1.start();
        t2.start();

        while(t1.isAlive()||t2.isAlive()){

        }

        System.out.println("程序结束");
    }
    @Override
    public void run() {
        synchronized (lock1){

            System.out.println("lock1开始执行---"+Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("lock1结束执行---"+Thread.currentThread().getName());
        }

        synchronized (lock2){

            System.out.println("lock2开始执行---"+Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("lock2结束执行---"+Thread.currentThread().getName());
        }
    }
}
