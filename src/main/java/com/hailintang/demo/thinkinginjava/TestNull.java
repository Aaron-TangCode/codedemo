package com.hailintang.demo.thinkinginjava;

public class TestNull {
    public static void main(String[] args) {
        TestNull m = (TestNull)null;

        System.out.println(m);
        m.doSomething();
    }

//    private static void doSomething(){
//        System.out.println("static doSomething");
//    }

    private void doSomething(){
        System.out.println("doSomething");
    }
}
