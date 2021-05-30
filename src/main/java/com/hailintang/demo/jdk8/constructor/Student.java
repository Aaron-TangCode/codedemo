package com.hailintang.demo.jdk8.constructor;

public class Student extends Person {
    /**
     * 输出：
     * Person-这是：有参构造函数
     * Student-这是：有参构造函数
     * @param name
     */
//    public Student(String name){
//        super(name);
//        System.out.println("Student-这是：有参构造函数");
//    }
    /**
     * 输出：
     * Person-这是：无参构造函数
     * Student-这是：有参构造函数
     * @param name
     */
    public Student(String name){
//        super(name);
//        super(name);
        System.out.println("Student-这是：有参构造函数");
    }

//    public Student(){
//        System.out.println("Student-这是：无参构造函数");
//    }
}
