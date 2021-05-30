package com.hailintang.demo.jdk8;

public class OverloadTest {
    class Father{}

    class Son extends Father{}

    public void doSomething(Father father){
        System.out.println("father");
    }

    public void doSomething(Son son){
        System.out.println("son");
    }


    public static void main(String[] args) {
        OverloadTest overloadTest = new OverloadTest();

        Father father = overloadTest.new Father();

        Father son = overloadTest.new Son();

        overloadTest.doSomething(father);
        overloadTest.doSomething(son);
    }

}
