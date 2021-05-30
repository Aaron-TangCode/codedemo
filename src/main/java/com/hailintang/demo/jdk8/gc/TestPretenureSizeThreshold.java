package com.hailintang.demo.jdk8.gc;

/**
 * -Xms20M
 * -Xmx20M
 * -Xmn10M
 * -verbose:gc
 * -XX:PretenureSizeThreshold=3145728
 * -XX:+PrintGCDetails
 */
public class TestPretenureSizeThreshold {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation = new byte[7 * _1MB];
    }
}
