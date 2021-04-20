package com.hailintang.demo.jdk8.gc;

public class FullGC {
    private static final int _1MB = 1024 * 1024;
    public static void main(String[] args) {

        touchFullGC();

    }

    public static void touchFullGC(){
//        byte[] array1 = new byte[4*_1MB]; //直接进入老年代
//        array1 = null;

        byte[] array2 = new byte[2*_1MB];
        byte[] array3 = new byte[2*_1MB];
        byte[] array4 = new byte[2*_1MB];
        byte[] array5 = new byte[128 * 1024];
        byte[] array6 = new byte[2*_1MB]; //这里会触发Minor gc
    }
}
