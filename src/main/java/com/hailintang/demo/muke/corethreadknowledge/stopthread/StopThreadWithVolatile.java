package com.hailintang.demo.muke.corethreadknowledge.stopthread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author hailin.tang
 * @date 2020/5/15 10:46 上午
 * @function
 */
public class StopThreadWithVolatile {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);
        Producer producer = new Producer(blockingQueue);

        Thread p = new Thread(producer);

        p.start();

        Consumer consumer = new Consumer(blockingQueue);

        Thread c = new Thread(consumer);

        c.start();

        Thread.sleep(3000);

//        producer.canceled = true;
        p.interrupt();

    }

}

class Producer implements Runnable {
    public static volatile boolean canceled = false;
    BlockingQueue<Integer> blockingQueue;

    public Producer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        int num = 0;
//        while(num<Integer.MAX_VALUE&&!canceled){
        try {
            while (num < Integer.MAX_VALUE && !Thread.currentThread().isInterrupted()) {
                //用volatile是不能终止线程的，因为生产者会被阻塞在put方法，压根没法检测canceled的状态。
                blockingQueue.put(num);
                System.out.println(num + "被放入仓库");

                if (num % 100 == 0) {
                }
                num++;
            }
            System.out.println("生产者结束生产");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable {
    BlockingQueue<Integer> blockingQueue;

    public Consumer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (Math.random() < 0.95) {
            try {
                Integer num = blockingQueue.take();
                System.out.println("消费数据:" + num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("停止消费");
    }
}