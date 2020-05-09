package com.hailintang.demo.muke;

/**
 * @author hailin.tang
 * @date 2020/4/20 8:50 下午
 * @function
 */
public class DispatchRequest1 implements Runnable {
    static DispatchRequest1 dispatchRequest1 = new DispatchRequest1();
    static int i = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(dispatchRequest1);
        Thread t2 = new Thread(dispatchRequest1);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
    @Override
    public void run() {
        for(int j=0;j<100000;j++){
            i++;
        }
    }
}
