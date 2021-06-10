package com.hailintang.demo.jdk8.gc;

public class Demo11 {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(30000);
        while (true){
            loadData();
        }
    }

    private static void loadData() throws InterruptedException {

        byte[] data = null;
        for (int i = 0; i < 50; i++) {
            data = new byte[100 * 1024];
        }
        data = null;

        Thread.sleep(1000);
    }
}
