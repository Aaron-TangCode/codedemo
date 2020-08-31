package com.hailintang.demo.jdk8.producerconsumer;

/**
 * @author hailin.tang
 * @date 2020/8/30 5:51 下午
 * @function
 */
public class Test {
    public static void main(String[] args) {
        Stroage stroage = new Stroage();
        Producer producer = new Producer(stroage);
        Consumer consumer = new Consumer(stroage);

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);

        t1.start();
        t2.start();
    }
}
