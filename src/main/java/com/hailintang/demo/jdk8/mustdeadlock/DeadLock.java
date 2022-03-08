package com.hailintang.demo.jdk8.mustdeadlock;

public class DeadLock {
    public static String obj1 = "obj1";
    public static String obj2 = "obj2";

    public static void main(String[] args) {
        Thread a = new Thread(new Lock1());
        Thread b = new Thread(new Lock2());
        a.start();
        b.start();
    }
}

class Lock1 implements Runnable{

    @Override
    public void run() {
        try {
            System.out.println("Lock1 running");
            while (true){
                synchronized (DeadLock.obj1){
                    System.out.println("Lock1 lock obj1");
                    Thread.sleep(3000L);
                    synchronized (DeadLock.obj2){
                        System.out.println("Lock2 lock obj2");
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Lock2 implements Runnable{

    @Override
    public void run() {
        try {
            System.out.println("Lock1 running");
            while(true){
                synchronized (DeadLock.obj2){
                    System.out.println("Lock2 lock obj2");
                    Thread.sleep(3000L);
                    synchronized (DeadLock.obj1){
                        System.out.println("Lock1 lock obj1");
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String str = "1~2~3";
        String[] split = str.split("~");
        System.out.println(split);
    }
}