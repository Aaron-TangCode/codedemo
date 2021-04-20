package com.hailintang.demo.jdk8.gc;

public class TestMaxTenuring {
    private static final int _1MB = 1024 * 1024;
    public static void main(String[] args) {
        byte[] allocation1;
        byte[] allocation2;
        byte[] allocation3;
        byte[] allocation4;

        allocation1 = new byte[_1MB/4];
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[6 * _1MB];

        allocation3 = null;

        allocation4 = new byte[4 * _1MB];
    }
}
