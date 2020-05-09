package com.hailintang.demo.geekbang.course10;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author hailin.tang
 * @date 2020-03-31 21:25
 * @function
 */
public class Test {

    private static List<List<Integer>> data = new ArrayList<>();


    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            List<Integer> rawList = IntStream.rangeClosed(1, 100000).boxed().collect(Collectors.toList());
            data.add(rawList.subList(0, 1));
        }
    }
}
