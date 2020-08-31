package com.hailintang.demo.muke.juctool.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author hailin.tang
 * @date 2020/6/13 11:50 下午
 * @function
 */
public class LongAdderDemo {
    public static void main(String[] args) {
        LongAdder atomicLong = new LongAdder();
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        long start = System.currentTimeMillis();
        for(int i=0;i<100000;i++){
            executorService.submit(new Task(atomicLong));
        }

        executorService.shutdown();

        while(!executorService.isTerminated()){

        }
        long end = System.currentTimeMillis();

        System.out.println(atomicLong.sum());
        System.out.println("LongAdder耗时："+(end-start));

    }
    static class Task implements Runnable{
        private LongAdder counter;

        public Task(LongAdder counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i=0;i<10000;i++){
                counter.increment();
            }
        }
    }
}

