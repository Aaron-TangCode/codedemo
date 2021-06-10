package com.hailintang.demo.jdk8.gc.oom;

import java.util.ArrayList;
import java.util.List;

public class Demo3 {
    static Double t;
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        int i = 0;
        while(true){
            list.add(new Object());
            System.out.println("创建对象"+(++i)+"个");
        }

//        System.out.println(t);
//        if(0.1!=0){
//            System.out.println(11);
//        }
    }
}
