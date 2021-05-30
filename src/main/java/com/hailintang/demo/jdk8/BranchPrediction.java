package com.hailintang.demo.jdk8;

/**
 * 分支预测
 */
public class BranchPrediction {
    public static void main(String args[]) {        
        test1();
        test2();
    }
    public static void test2(){
        long start = System.currentTimeMillis();
        int i=0;
        int j=0;
        int k=0;
        for (; i < 100; i++) {
            j = 0;
            for (; j <1000; j ++) {
                k = 0;
                for (; k < 10000; k++) {
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Time spent is " + (end - start)+"ms");

        start = System.currentTimeMillis();
        i = 0;
        for (; i < 10000; i++) {
            j = 0;
            for (; j <1000; j ++) {
                k = 0;
                for (; k < 100; k++) {
                }
            }
        }
        end = System.currentTimeMillis();
        System.out.println("Time spent is " + (end - start) + "ms");
    }
    public static void test1(){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j <1000; j ++) {
                for (int k = 0; k < 10000; k++) {
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Time spent is " + (end - start)+"ms");

        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j <1000; j ++) {
                for (int k = 0; k < 100; k++) {
                }
            }
        }
        end = System.currentTimeMillis();
        System.out.println("Time spent is " + (end - start) + "ms");
    }
}