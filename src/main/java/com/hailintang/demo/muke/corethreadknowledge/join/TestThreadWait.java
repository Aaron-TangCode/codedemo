package com.hailintang.demo.muke.corethreadknowledge.join;

/**
 * @author hailin.tang
 * @date 2020/5/18 10:11 下午
 * @function
 */
public class TestThreadWait{

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("111");
                try {
                    wait();
                    System.out.println("222");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}
