package com.hailintang.demo.muke.juctool.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author hailin.tang
 * @date 2020/6/13 11:29 下午
 * @function
 */
public class AtomicIntegerFieldUpdaterDemo implements Runnable {
    static Candidate tom;
    static Candidate peter;

    @Override
    public void run() {
        for (int i=0;i<10000;i++){
            tom.score++;
            updater.getAndIncrement(peter);
        }
    }

    public static class Candidate{
        volatile int score;
    }

    public static AtomicIntegerFieldUpdater<Candidate> updater =
            AtomicIntegerFieldUpdater.newUpdater(Candidate.class,"score");

    public static void main(String[] args) throws InterruptedException {
        tom = new Candidate();
        peter = new Candidate();
        AtomicIntegerFieldUpdaterDemo demo = new AtomicIntegerFieldUpdaterDemo();
        Thread t1 = new Thread(demo);
        Thread t2 = new Thread(demo);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("线程执行结束");
        System.out.println("tom's score="+tom.score);
        System.out.println("peter's score="+peter.score);
    }




}
