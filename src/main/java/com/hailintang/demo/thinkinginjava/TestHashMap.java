package com.hailintang.demo.thinkinginjava;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hailin.tang
 * @date 2020/8/9 12:55 上午
 * @function
 */
public class TestHashMap {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>(17);

        map.putIfAbsent(1,1);
        map.putIfAbsent(1,2);
        map.putIfAbsent(2,2);
        System.out.println(map);
    }
}
