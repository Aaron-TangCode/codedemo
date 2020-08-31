package com.hailintang.demo.muke.corethreadknowledge.threadstate;

/**
 * @author hailin.tang
 * @date 2020/5/15 4:49 下午
 * @function
 */
public class BlockedWaitingTimeWaiting implements Runnable{
    public static void main(String[] args) {
        BlockedWaitingTimeWaiting timeWaiting = new BlockedWaitingTimeWaiting();
        Thread t1 = new Thread(timeWaiting);
        t1.start();
        Thread t2 = new Thread(timeWaiting);
        t2.start();
        System.out.println(t1.getState());
        System.out.println(t2.getState());
        try {
            Thread.sleep(1200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t1.getState());
    }
    @Override
    public void run() {
        syn();
    }

    private synchronized void syn() {
        try {
            Thread.sleep(1000);
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
