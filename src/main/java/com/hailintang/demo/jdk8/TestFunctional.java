package com.hailintang.demo.jdk8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author Aaron
 * @date 2020-03-20 08:52
 * @function
 */
public class TestFunctional {
    /**
     * lambda 四大函数式接口
     * Consumer: void accept(T t)
     * Supplier: T get()
     * Functional: T apply(R r)
     * Predicate: boolean test(T t)
     */
    @Test
    public void test1(){
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("去超市买东西，消费："+aDouble);
            }
        });
        System.out.println("====================");

        happyTime(500,(money) -> {
            System.out.println("去超市买东西，消费："+money);
        });
    }

    public void happyTime(double money, Consumer<Double> consumer){
        consumer.accept(money);
    }

    @Test
    public void test2(){
        List<String> list = Arrays.asList("北京","东京","南京","西京","普京","天津");
        List<String> newList = filterList(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(newList);


        System.out.println("==================");

        List<String> list1 = filterList(list, s -> s.contains("津"));
        System.out.println(list1);
    }

    /**
     * 根据某种规则过滤字符串
     * @param list
     * @param predicate
     * @return
     */
    public List<String> filterList(List<String> list, Predicate<String> predicate){
        List<String> res = new ArrayList<>();
        for (String s : list) {
            if (predicate.test(s)) {
                res.add(s);
            }
        }
        return res;
    }
}
