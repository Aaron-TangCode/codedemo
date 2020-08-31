package com.hailintang.demo.muke.corethreadknowledge.join;

/**
 * @author hailin.tang
 * @date 2020/5/18 9:26 下午
 * @function
 */
public class TestJoin {



    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        Runnable runnable = ()->{
            try {
                Thread.sleep(1000);
                mainThread.getState();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName());
            e.printStackTrace();
        }

    }
}
