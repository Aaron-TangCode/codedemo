package com.hailintang.demo.muke.corethreadknowledge.uncaughtexception;

import java.util.stream.Stream;

/**
 * @author hailin.tang
 * @date 2020/5/19 9:23 下午
 * @function
 */
public class ExceptionInChildThread implements Runnable{
    public static void main(String[] args) {
        new Thread(new ExceptionInChildThread()).start();
        Stream.iterate(0,t->t+2).limit(1000).forEach(System.out::println);
    }
    @Override
    public void run() {
        throw new RuntimeException();
    }
}
