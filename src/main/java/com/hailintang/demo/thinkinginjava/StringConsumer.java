package com.hailintang.demo.thinkinginjava;

import java.util.ArrayList;
import java.util.List;

public class StringConsumer implements Consumer<String> {
    @Override
    public void accept(String s) {
        System.out.println("i consume "+s);
    }

    public static void main(String[] args) {
        StringConsumer stringConsumer = new StringConsumer();
        stringConsumer.accept("aaa");
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        for (Integer integer : list) {
            
        }

        for (int i = 0; i < list.size(); i++) {
            
        }
    }

}
