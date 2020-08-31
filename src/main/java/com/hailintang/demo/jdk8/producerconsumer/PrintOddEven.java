package com.hailintang.demo.jdk8.producerconsumer;

/**
 * @author hailin.tang
 * @date 2020/8/30 7:00 下午
 * @function 两个线程交替打印0-100奇偶数
 */
public class PrintOddEven {
    static Object lock = new Object();
    public static int count = 0;
    public static void main(String[] args) {
        new Thread(()->{
            while(count<100){
                synchronized (lock){
                    if((count&1)==1){
                        System.out.println(Thread.currentThread().getName()+":"+count++);
                    }
                }
            }
        },"奇数").start();
        new Thread(()->{
            while(count<100){
                synchronized (lock){
                    if((count&1)==0){
                        System.out.println(Thread.currentThread().getName()+":"+count++);
                    }
                }
            }
        },"偶数").start();
    }
}
