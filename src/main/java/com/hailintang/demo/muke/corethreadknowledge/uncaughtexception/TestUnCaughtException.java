package com.hailintang.demo.muke.corethreadknowledge.uncaughtexception;

/**
 * @author hailin.tang
 * @date 2020/5/19 9:54 下午
 * @function
 */
public class TestUnCaughtException implements Runnable{

    public static void main(String[] args) {
        MyUncaughtExceptionHandler myUncaughtExceptionHandler = new MyUncaughtExceptionHandler("牛逼123123123");
        Thread.setDefaultUncaughtExceptionHandler(myUncaughtExceptionHandler);
        new Thread(new TestUnCaughtException(),"线程1").start();
        new Thread(new TestUnCaughtException(),"线程2").start();
        new Thread(new TestUnCaughtException(),"线程3").start();
        new Thread(new TestUnCaughtException(),"线程4").start();
    }
    @Override
    public void run() {
        throw new RuntimeException();
    }
}
