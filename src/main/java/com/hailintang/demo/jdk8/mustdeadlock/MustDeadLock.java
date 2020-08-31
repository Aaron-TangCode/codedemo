package com.hailintang.demo.jdk8.mustdeadlock;

/**
 * @author hailin.tang
 * @date 2020/8/30 10:12 下午
 * @function
 */
public class MustDeadLock implements Runnable {
    //锁要求是static
    static Object obj1 = new Object();
    static Object obj2 = new Object();
    int flag = 1;
    public static void main(String[] args) {
        MustDeadLock m1 = new MustDeadLock();
        MustDeadLock m2 = new MustDeadLock();
        m1.flag = 1;
        m2.flag = 0;
        Thread t1 = new Thread(m1,"线程1");
        Thread t2 = new Thread(m2,"线程2");

        t1.start();
        t2.start();
    }
    @Override
    public void run() {
        System.out.println("flag = "+flag);
        if(flag==1){
            synchronized (obj1){
                System.out.println(Thread.currentThread().getName()+"成功获取锁1");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj2){
                    System.out.println(Thread.currentThread().getName()+"成功获取2把锁");
                }
            }
        }
        if(flag==0){
            synchronized (obj2) {
                System.out.println(Thread.currentThread().getName() + "成功获取锁2");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj1) {
                    System.out.println(Thread.currentThread().getName() + "成功获取2把锁");
                }
            }
        }
    }
}
