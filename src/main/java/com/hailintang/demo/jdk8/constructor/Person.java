package com.hailintang.demo.jdk8.constructor;

public class Person {
    private String name;
    public Person(){
        System.out.println("Person-这是：无参构造函数");
    }

    public Person(String name){
        this.name = name;
        System.out.println("Person-这是：有参构造函数");
    }
}
