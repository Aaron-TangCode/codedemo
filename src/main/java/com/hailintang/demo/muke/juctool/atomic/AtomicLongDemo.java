package com.hailintang.demo.muke.juctool.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author hailin.tang
 * @date 2020/6/13 11:50 下午
 * @function
 */
public class AtomicLongDemo {
    public static void main(String[] args) {
        AtomicLong atomicLong = new AtomicLong(0);
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        long start = System.currentTimeMillis();
        for(int i=0;i<100000;i++){
            executorService.submit(new Task(atomicLong));
        }

        executorService.shutdown();

        while(!executorService.isTerminated()){

        }
        long end = System.currentTimeMillis();

        System.out.println(atomicLong.get());
        System.out.println("AtomicLong耗时："+(end-start));

    }
    static class Task implements Runnable{
        private AtomicLong counter;

        public Task(AtomicLong counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i=0;i<10000;i++){
                counter.getAndIncrement();
            }
        }
    }
}

