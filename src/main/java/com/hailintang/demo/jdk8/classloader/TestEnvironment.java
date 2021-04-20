package com.hailintang.demo.jdk8.classloader;

public class TestEnvironment {
    public static void main(String[] args) {
        //启动类加载器
        System.out.println("1"+System.getProperty("sun.boot.class.path"));
        //扩展类加载器
        System.out.println("2"+System.getProperty("java.ext.dirs"));
        //应用类加载器
        System.out.println("3"+System.getProperty("java.class.path"));
    }
}
