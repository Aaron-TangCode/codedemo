package com.hailintang.demo.jdk8.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author hailin.tang
 * @date 2020/8/30 11:04 下午
 * @function
 */
public class BlockingQueueDemo  {
    private static BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(10);

    public static void main(String[] args) throws InterruptedException {
        Producer p1 = new Producer();
        Consumer s1 = new Consumer();

        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(s1);

        t1.start();
        Thread.sleep(500);
        t2.start();
    }

    static class Producer implements Runnable{
        @Override
        public void run() {
            for(int i=1;i<=100;i++){
                try {
                    blockingQueue.put(i);
                    System.out.println("生产："+i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer implements Runnable{

        @Override
        public void run() {
            for(int i=0;i<100;i++){
                try {
                    Integer take = blockingQueue.take();
                    System.out.println("消费:"+take);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
