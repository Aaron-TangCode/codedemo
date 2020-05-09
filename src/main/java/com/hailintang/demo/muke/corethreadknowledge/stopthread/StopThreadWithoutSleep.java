package com.hailintang.demo.muke.corethreadknowledge.stopthread;

/**
 * @author hailin.tang
 * @date 2020/5/7 3:59 下午
 * @function 在没sleep或wait的状态下，停止线程
 */
public class StopThreadWithoutSleep implements Runnable{
    @Override
    public void run() {
        int num = 0;
        while(!Thread.currentThread().isInterrupted()&&num<=Integer.MAX_VALUE/2){
            if(num%10000==0){
                System.out.println(num+"是10000的倍数");
            }
            num++;
        }
        System.out.println("完毕");

    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new StopThreadWithoutSleep());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();

    }
}
