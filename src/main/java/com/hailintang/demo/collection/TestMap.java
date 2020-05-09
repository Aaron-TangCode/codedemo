package com.hailintang.demo.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hailin.tang
 * @date 2020-03-26 22:24
 * @function
 */
public class TestMap {
    @Test
    public void test1(){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"a");
        System.out.println(map);

        System.out.println("=========");


        map.putIfAbsent(2,"b");

        System.out.println(map);

        map.put(1,"c");
        System.out.println("==========");

        map.putIfAbsent(2,"d");

        System.out.println(map);
    }
}
