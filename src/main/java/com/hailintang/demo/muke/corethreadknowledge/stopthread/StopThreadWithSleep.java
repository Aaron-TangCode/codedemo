package com.hailintang.demo.muke.corethreadknowledge.stopthread;

/**
 * @author hailin.tang
 * @date 2020/5/7 4:20 下午
 * @function
 */
public class StopThreadWithSleep {


    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = ()->{
            int num = 0;
//            while(!Thread.currentThread().isInterrupted()&&num<=300){
            while(num<=300){
                if(num%100==0){
                    System.out.println(num+"是100的倍数");
                }
                num++;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(500);
        thread.interrupt();
    }
}
