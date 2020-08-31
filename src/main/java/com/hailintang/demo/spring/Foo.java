package com.hailintang.demo.spring;

/**
 * @author hailin.tang
 * @date 2020/5/24 3:01 下午
 * @function
 */
public class Foo {
    private Bar bar;
    public Foo(Bar bar){
        this.bar = bar;
        System.out.println("完成foo的构造方法调用");
    }
}
