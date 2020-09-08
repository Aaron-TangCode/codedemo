package com.hailintang.demo.jdk8.list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description: 测试list的交集，并集，差集
 * @Author: tanghailin
 * @Date: 2020/8/27 11:15 上午
 */
public class TestList {
    public static void main(String[] args) {
        List<String> listA = new ArrayList<>();
        List<String> listB = new ArrayList<>();

        listA.add("A");
        listA.add("B");
        listB.add("B");
        listB.add("C");


        System.out.println("交集：" + getRetainAll(listA,listB));
        System.out.println("并集：" + getAddAll(listA,listB));
        System.out.println("差集：" + getRemoveAll(listA,listB));
    }


    public static List<String> getRetainAll(List<String> listA, List<String> listB) {
        List<String> tmpA = new ArrayList<>(listA);
        List<String> tmpB = new ArrayList<>(listB);

        tmpA.retainAll(tmpB);

        return tmpA;
    }

    public static List<String> getAddAll(List<String> listA, List<String> listB) {
        List<String> tmpA = new ArrayList<>(listA);
        List<String> tmpB = new ArrayList<>(listB);

        tmpA.addAll(tmpB);

        return tmpA;
    }

    public static List<String> getRemoveAll(List<String> listA, List<String> listB) {
        List<String> tmpA = new ArrayList<>(listA);
        List<String> tmpB = new ArrayList<>(listB);

        tmpA.removeAll(tmpB);

        return tmpA;
    }
}
