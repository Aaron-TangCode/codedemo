package com.hailintang.demo.muke.juctool.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hailin.tang
 * @date 2020/6/13 8:57 下午
 * @function 原子类的粒度是最小的。粒度更小，效率更高。原子类的粒度是变量，也就是最小的。
 */
public class AtomicIntegerDemo1 implements Runnable {
    private static AtomicInteger atomicInteger = new AtomicInteger();

    private void atomicIncrement(){
//        atomicInteger.getAndIncrement();// 20000
//        atomicInteger.getAndDecrement();// -20000
        //每次可以加10
//        atomicInteger.getAndAdd(10);// 200000
        atomicInteger.getAndAdd(-90);// -1800000
    }

    private static volatile int basicCount = 0;

    /**
     * 线程不安全
     */
//    private static void normalIncrement(){
//        basicCount++;
//    }

    /**
     * 线程安全
     */
    private synchronized static void normalIncrement(){
        basicCount++;
    }


    @Override
    public void run() {
        for (int i=0;i<10000;i++){
            atomicIncrement();
            normalIncrement();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerDemo1 demo1 = new AtomicIntegerDemo1();
        Thread t1 = new Thread(demo1);
        Thread t2 = new Thread(demo1);
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("原子类："+atomicInteger.get());
        System.out.println("普通类："+basicCount);
    }
}
