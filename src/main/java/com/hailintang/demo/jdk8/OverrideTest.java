package com.hailintang.demo.jdk8;

public class OverrideTest {

    class Father{
        public void doSomething(){
            System.out.println("father");
        }
    }

    class Son extends Father{
        @Override
        public void doSomething() {
            System.out.println("son");
        }
    }

    public static void main(String[] args) {
        OverrideTest overrideTest = new OverrideTest();
        Father father = overrideTest.new Father();
        Father son = overrideTest.new Son();

        father.doSomething();
        son.doSomething();
    }
}
