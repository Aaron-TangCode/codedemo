package com.hailintang.demo.jdk8.gc;

import java.util.ArrayList;
import java.util.List;

public class TestYoungGC {
    public static void main(String[] args) throws InterruptedException {
        List<Object> list = new ArrayList<>();

        while(true){
            Thread.sleep(1);
            list.add(new Object());
        }
    }
}
