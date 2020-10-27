package com.hailintang.demo.thinkinginjava;

import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("com.hailintang.demo.thinkinginjava.Test");

        Method method = clazz.getMethod("target", int.class);
        for(int i=0;i<20;i++){
            method.invoke(null,i);
        }
    }

    public static void target(int i){
        new Exception("# "+i).printStackTrace();
    }


}
