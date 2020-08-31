package com.hailintang.demo.muke.corethreadknowledge.deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @author hailin.tang
 * @date 2020/5/21 11:47 上午
 * @function
 */
public class TestDeadLockByMX implements Runnable{
    int flag = 1;
    static Object lock1 = new Object();
    static Object lock2 = new Object();

    public static void main(String[] args) throws InterruptedException {
        TestDeadLockByMX testDeadLock1 = new TestDeadLockByMX();
        TestDeadLockByMX testDeadLock2= new TestDeadLockByMX();
        testDeadLock1.flag = 1;
        testDeadLock2.flag = 0;
        Thread t1 = new Thread(testDeadLock1);
        Thread t2 = new Thread(testDeadLock2);

        t1.start();
        t2.start();

        Thread.sleep(2000);
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        //死锁线程的id
        long[] deadlockedThreads = threadMXBean.findDeadlockedThreads();
        ThreadInfo threadInfo1 = threadMXBean.getThreadInfo(deadlockedThreads[0]);
        ThreadInfo threadInfo2 = threadMXBean.getThreadInfo(deadlockedThreads[1]);
        System.out.println(threadInfo1);
        System.out.println(threadInfo2);
        System.out.println("程序结束");
    }
    @Override
    public void run() {
        if(flag==1){
            synchronized (lock1){
                try {
                    Thread.sleep(1000);
                    System.out.println("123");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println("成功拿到线程1和2的锁");
                }
            }
        }

        if(flag==0){
            synchronized (lock2){
                try {
                    Thread.sleep(1000);
                    System.out.println("321");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1){
                    System.out.println("牛逼1");
                }
            }
        }
    }
}
