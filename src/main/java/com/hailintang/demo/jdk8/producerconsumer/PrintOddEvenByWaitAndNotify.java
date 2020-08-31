package com.hailintang.demo.jdk8.producerconsumer;

/**
 * @author hailin.tang
 * @date 2020/8/30 9:09 下午
 * @function
 */
public class PrintOddEvenByWaitAndNotify {
    private static int count = 0;
    private static Object lock = new Object();

    public static void main(String[] args) {
        new Thread(new TurningRunnable(),"偶数").start();
        new Thread(new TurningRunnable(),"奇数").start();
    }
    static class TurningRunnable implements Runnable{

        @Override
        public void run() {
            while(count<=100){
                synchronized (lock){
                    //获取到锁就打印
                    System.out.println(Thread.currentThread().getName()+":"+count++);
                    //释放另一个线程
                    lock.notify();
                    if(count<=100){
                        try {
                            //如果任务还没结束，就让出当前的锁
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
