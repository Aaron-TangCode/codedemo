package com.hailintang.demo.jdk8.gc;

public class MinorGC {
    /**
     * VM参数：-verbose gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8
     * -Xms 堆的最小值
     * -Xmx 堆的最大值
     * -Xmn 新生代的大小
     * 老年代大小= xmx - xmn
     *
     * @param args
     */
    private static final int _1MB = 1024 * 1024;

    //    public static void main(String[] args) {
//        byte[] allocation1,allocation2,allocation3,allocation4;
//        allocation1 = new byte[2 * _1MB];
//        allocation2 = new byte[2 * _1MB];
//        allocation3 = new byte[2 * _1MB];
//        allocation4 = new byte[4 * _1MB];
//
//    }
    public static void main(String[] args) {
        byte[] array1 = new byte[_1MB];
        array1 = new byte[_1MB];
        array1 = new byte[_1MB];
        array1 = null;

        byte[] array2 = new byte[2*_1MB];

    }
}
