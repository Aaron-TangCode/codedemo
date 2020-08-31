package com.hailintang.demo.muke.corethreadknowledge.producerconsumerstyle;

/**
 * @author hailin.tang
 * @date 2020/5/18 8:51 下午
 * @function
 */
public class Test {
    public static void main(String[] args) {
        Storage storage = new Storage();
        Producer producer = new Producer(storage);
        Consumer consumer = new Consumer(storage);

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);
        t1.start();
        t2.start();
    }
}
