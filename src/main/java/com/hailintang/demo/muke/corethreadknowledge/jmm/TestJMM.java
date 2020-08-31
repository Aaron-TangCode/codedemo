package com.hailintang.demo.muke.corethreadknowledge.jmm;

import java.util.concurrent.CountDownLatch;

/**
 * @author hailin.tang
 * @date 2020/6/1 7:13 下午
 * @function
 */
public class TestJMM {
    private static int a = 0;
    private static int b = 0;
    private static int x = 0;
    private static int y = 0;

    public static void main(String[] args) throws InterruptedException {
        int count = 0;
        for(;;){
            count++;
            a = 0;
            b = 0;
            x = 0;
            y = 0;
            CountDownLatch latch = new CountDownLatch(1);
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    a = 1;
                    x = b;
                }
            });
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    b = 1;
                    y = a;
                }
            });

            t1.start();
            t2.start();
            latch.countDown();
            t1.join();
            t2.join();

            String res = "第"+count+"次（"+x+","+y+")";
            System.out.println(res);
            if(x==1&&y==1){
                break;
            }
        }
    }
}
