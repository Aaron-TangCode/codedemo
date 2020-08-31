package com.hailintang.demo.muke.corethreadknowledge.threadstate;

/**
 * @author hailin.tang
 * @date 2020/5/15 4:29 下午
 * @function new :新建
 * Runnable:可运行状态，正在运行状态
 * Terminated：停止状态
 */
public class NewRunnableTerminated implements Runnable{
    public static void main(String[] args) throws InterruptedException {
        NewRunnableTerminated newRunnableTerminated = new NewRunnableTerminated();
        Thread thread = new Thread(newRunnableTerminated);
        //NEW
        System.out.println(thread.getState());
        thread.start();
        //RUNNABLE
        System.out.println(thread.getState());
        Thread.sleep(10);
        //RUNNABLE
        System.out.println(thread.getState());
        Thread.sleep(100);
        //TERMINATED
        System.out.println(thread.getState());



    }
    @Override
    public void run() {
        for (int i=0;i<1000;i++){
            System.out.println(i);
        }
    }
}
