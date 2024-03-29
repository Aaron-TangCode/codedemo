package com.hailintang.demo.jdk8.mustdeadlock;

import java.util.ArrayList;
import java.util.List;

public class Something {
    private Buffer mBuf = new Buffer();

    public void produce() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName()+"成功获取锁");
            while (mBuf.isFull()) {
                try {
                    System.out.println(Thread.currentThread().getName()+"进行等待");
                    System.out.println(Thread.currentThread().getName()+"释放锁");
                    wait();
                    System.out.println(Thread.currentThread().getName()+"释放等待");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            mBuf.add();
            notify();
        }
    }

    public void consume() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName()+"成功获取锁");
            while (mBuf.isEmpty()) {
                try {
                    System.out.println(Thread.currentThread().getName()+"进行等待");
                    System.out.println(Thread.currentThread().getName()+"释放锁");
                    wait();
                    System.out.println(Thread.currentThread().getName()+"释放等待");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            mBuf.remove();
            notify();
        }
    }

    private class Buffer {
        private static final int MAX_CAPACITY = 1;
        private List innerList = new ArrayList<>(MAX_CAPACITY);

        void add() {
            if (isFull()) {
                throw new IndexOutOfBoundsException();
            } else {
                innerList.add(new Object());
            }
            System.out.println(Thread.currentThread().getName() + " add");

        }

        void remove() {
            if (isEmpty()) {
                throw new IndexOutOfBoundsException();
            } else {
                innerList.remove(MAX_CAPACITY - 1);
            }
            System.out.println(Thread.currentThread().getName() + " remove");
        }

        boolean isEmpty() {
            return innerList.isEmpty();
        }

        boolean isFull() {
            return innerList.size() == MAX_CAPACITY;
        }
    }

    public static void main(String[] args) {
        Something sth = new Something();
        Runnable runProduce = new Runnable() {
            int count = 4;

            @Override
            public void run() {
                while (count-- > 0) {
                    sth.produce();
                }
            }
        };
        Runnable runConsume = new Runnable() {
            int count = 4;

            @Override
            public void run() {
                while (count-- > 0) {
                    sth.consume();
                }
            }
        };
        for (int i = 0; i < 2; i++) {
            new Thread(runConsume,"消费者"+i).start();
        }
        for (int i = 0; i < 2; i++) {
            new Thread(runProduce,"生产者"+i).start();
        }
    }
}