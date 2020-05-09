package com.hailintang.demo.jdk8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.*;

/**
 * @author hailin.tang
 * @date 2020-03-24 10:48
 * @function 学习lambda表达式的方法引用
 */
public class TestMethodRef {
    @Test
    public void test01(){
        Consumer<String> con1 = str -> System.out.println(str);
        con1.accept("北京");
        /// 方法引用是lambda表达式的语法糖，方法引用本质也是lambda表达式
        /// 方法引用：类(或对象)::方法
        /// 类：：静态方法/实例方法
        /// 对象：：实例方法
        /// 方法引用的条件：函数式接口的形参和返回值，要和被调用的方法的形参和返回值一致。
        /// 比如：void accept(T t)、void println(T t)。适用于：类：：静态方法，对象：：实例方法
        System.out.println("===================");
        Consumer<String> con2 = System.out::println;
        con2.accept("广州");
    }

    @Test
    public void test02(){
        /**
         * supplier T get()
         * User String getName()
         * 二者的参数和返回值类型是一致的，可以用方法引用
         */
        User user = new User(1,"hailin.tang");
        Supplier<String> supplier1 = () -> user.getName();
        System.out.println(supplier1.get());
        System.out.println("=============");
        Supplier<String> supplier2 = user::getName;
        System.out.println(supplier2.get());
    }

    @Test
    public void test03(){
        Function<Double,Long> func = new Function<Double, Long>() {
            @Override
            public Long apply(Double d) {
                return Math.round(d);
            }
        };
        System.out.println(func.apply(12.3));
        System.out.println("=================");
        Function<Double,Long> fun1 = (x) -> {return Math.round(x);};
        System.out.println(fun1.apply(12.3));
        System.out.println("=================");
        Function<Double,Long> fun2 = Math::round;
        System.out.println(fun2.apply(12.3));
        /**
         * 类：：静态方法
         * Math的Long round(Double d)
         * Functional的 R apply(T t)
         */

    }
    @Test
    public void test4(){
        /**
         * 类：：实例方法（比较难理解）
         * Comparator中的int compare(T t1,T t2)
         * String中的int t1.compareTo(t2)
         * 这里的参数个数明显不一样，为啥还可以用方法引用？
         * 因为t1刚好是方法的调用者，t2刚好是参数，所以可以使用。
         */
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        };
        System.out.println(com1.compare(1, 3));
        System.out.println("=================");
        Comparator<Integer> com2 = (t1,t2) -> {
            return t1-t2;
        };

        System.out.println(com2.compare(1, 3));
        System.out.println("=================");

        Comparator<Integer> com3 = Integer::compareTo;
        System.out.println(com3.compare(1, 3));
    }
    @Test
    public void test5(){
        /**
         * BiPredicate中的boolean test(T t1,T t2);
         * String boolean t1.equals(t2)
         */
        BiPredicate<String,String> pre1 = (t1,t2) -> t1.equals(t2);
        System.out.println(pre1.test("abc", "abc"));

        System.out.println("===========================");

        BiPredicate<String,String> pre2 = String::equals;
        System.out.println(pre2.test("bc","bc"));
    }
    @Test
    public void test6(){
        /**
         * Functional中的R apply(T t)
         * User中的String getName()
         */
        User user = new User(2,"Aaron");
        Function<User,String> func1 = (x) -> x.getName();
        System.out.println(func1.apply(user));

        System.out.println("=======================");
        Function<User,String> func2 = User::getName;
        System.out.println(func2.apply(user));
    }
    @Test
    public void test7(){
        /**
         * 练习构造方法引用
         */
        Supplier<User> supplier1 = () -> new User();

        System.out.println(supplier1.get());

        Supplier<User> supplier2 = User::new;

        System.out.println(supplier2.get());

        Function<Integer,User> func1 = (x) -> new User(x);
        System.out.println(func1.apply(3).getId());

        Function<Integer,User> func2 = User::new;
        System.out.println(func2.apply(4).getId());

        BiFunction<Integer,String,User> func3 = (x,y) -> new User(x,y);
        System.out.println(func3.apply(5,"aasd").getName());

        BiFunction<Integer,String,User> func4 = User::new;
        System.out.println(func4.apply(6,"as").getName());
    }

    @Test
    public void test8(){
        /**
         * 数组引用
         */
        Function<Integer,String[]> func1 = (length) -> new String[length];
        System.out.println(Arrays.asList(func1.apply(5)));

        Function<Integer,String[]> func2 = String[]::new;
        System.out.println(Arrays.asList(func2.apply(6)));
    }
}
