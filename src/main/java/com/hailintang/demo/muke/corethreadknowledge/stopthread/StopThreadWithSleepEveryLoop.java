package com.hailintang.demo.muke.corethreadknowledge.stopthread;

/**
 * @author hailin.tang
 * @date 2020/5/14 7:45 下午
 * @function 如果每次循环都阻塞，那么不用每次迭代时检测中断状态。因为sleep过程中，会检测中断
 */
public class StopThreadWithSleepEveryLoop {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            int num = 0;
//            while(!Thread.currentThread().isInterrupted()&&num<=300){
            try {
                while (num <= 300) {
                    if (num % 100 == 0) {
                        System.out.println(num + "是100的倍数");
                    }
                    num++;

                    Thread.sleep(10);

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }
}
