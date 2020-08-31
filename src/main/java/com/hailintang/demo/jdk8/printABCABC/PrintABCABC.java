package com.hailintang.demo.jdk8.printABCABC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hailin.tang
 * @date 2020/8/30 9:46 下午
 * @function
 */
public class PrintABCABC implements Runnable{
    private static final int COUNT = 10;
    //锁
    private ReentrantLock reentrantLock;
    //当前线程
    private Condition curCondition;
    //下一个线程
    private Condition nextCondition;
    //打印字符
    private String printChar;

    public PrintABCABC(ReentrantLock reentrantLock, Condition curCondition, Condition nextCondition, String printChar) {
        this.reentrantLock = reentrantLock;
        this.curCondition = curCondition;
        this.nextCondition = nextCondition;
        this.printChar = printChar;
    }

    @Override
    public void run() {
        //获取打印锁
        reentrantLock.lock();
        try {
            for (int i=0;i<10;i++){
                //打印字符
                System.out.println(printChar);
                //使用nextCondition唤醒下一个线程
                nextCondition.signal();
                //必须要加判断，否则最后一次会出现死锁
                if(i<COUNT-1){
                    try {
                        curCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition A = lock.newCondition();
        Condition B = lock.newCondition();
        Condition C = lock.newCondition();

        //实例化A线程
        PrintABCABC printA = new PrintABCABC(lock,A,B,"A");
        PrintABCABC printB = new PrintABCABC(lock,B,C,"B");
        PrintABCABC printC = new PrintABCABC(lock,C,A,"C");

        Thread threadA = new Thread(printA);
        Thread threadB = new Thread(printB);
        Thread threadC = new Thread(printC);

        threadA.start();
        Thread.sleep(100);
        threadB.start();
        Thread.sleep(100);
        threadC.start();
    }
}
