package com.hailintang.demo.jdk8;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author Aaron
 * @date 2020-03-19 22:11
 * @function
 */
public class TestLambda {
    @Test
    public void test1(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2,o1);
            }
        };
        int compare = com1.compare(23, 11);
        System.out.println(compare);

        System.out.println("===============");

        Comparator<Integer> com2 = (O1,O2)-> Integer.compare(O2,O1);
        int compare1 = com2.compare(23, 11);
        System.out.println(compare1);

        Comparator<Integer> com3 = Integer::compare;
        int compare2 = com3.compare(23, 11);
        System.out.println(compare2);

    }

    /**
     * 语法格式一：接口方法无参数，无返回值
     */
    @Test
    public void test2(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("you are a laji");
            }
        };
        r1.run();

        Runnable r2 = () -> System.out.println("you are a laji2");

        r2.run();
    }

    /**
     * 语法格式二：接口方法有参数，无返回值
     */
    @Test
    public void test3(){
        Consumer<String> con1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con1.accept("lambda is very strong");

        Consumer<String> con2 = (s) -> {
            System.out.println(s);
        };
        con2.accept("lambda is so sick");
    }
}
