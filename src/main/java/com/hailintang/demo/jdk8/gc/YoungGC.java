package com.hailintang.demo.jdk8.gc;

public class YoungGC {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {

//        dynamicAllocate();
//        survivor_area();
        bigObject();
//        _15_year();
    }

    /**
     * 动态分配
     * 问题1：什么时候触发动态年龄判断？
     *
     * 每一次minor gc，都会触发动态年龄判断
     */
    public static void dynamicAllocate(){
        //jvm配置：-XX:NewSize=10m -XX:MaxNewSize=10m -XX:InitialHeapSize=20m -XX:MaxHeapSize=20m -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=10m -XX:MaxTenuringThreshold=15 -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc4.log
        byte[] array1 = new byte[2*_1MB];
        array1 = new byte[2*_1MB];
        array1 = new byte[2*_1MB];
        array1 = null;

        byte[] array2 = new byte[300 * 1024];

        byte[] array3 = new byte[2* _1MB];//这里触发第一次minor gc

        array3 = new byte[2* _1MB];
        array3 = new byte[2* _1MB];
        array3 = new byte[300 * 1024];
        array3 = null;

        byte[] array4 = new byte[2*_1MB]; //这里触发第二次minor gc
    }

    /**
     * 大对象
     */
    public static void bigObject(){
        //jvm配置：-XX:NewSize=10m
        // -XX:MaxNewSize=10m
        // -XX:InitialHeapSize=20m
        // -XX:MaxHeapSize=20m
        // -XX:SurvivorRatio=8
        // -XX:PretenureSizeThreshold=3m
        // -XX:MaxTenuringThreshold=15
        // -XX:+UseParNewGC
        // -XX:+UseConcMarkSweepGC
        // -XX:+PrintGCDetails
        // -XX:+PrintGCTimeStamps
        // -Xloggc:bigobject.log
        // eden
        byte[] array1 = new byte[2*_1MB];
        // old
        byte[] array2 = new byte[3*_1MB];
    }
    /**
     * 15岁
     */
    public static void _15_year(){
        //jvm配置：-XX:NewSize=10m -XX:MaxNewSize=10m -XX:InitialHeapSize=20m -XX:MaxHeapSize=20m -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3m -XX:MaxTenuringThreshold=3 -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc4.log

        byte[] array1 = new byte[2*_1MB];
        array1 = new byte[2*_1MB];
        array1 = new byte[2*_1MB];


        byte[] array2 = new byte[128*1024];//经过三次GC后，想让这个128K进入老年代

        array1 = null;

        byte[] array3 = new byte[2*_1MB];//第一次minor gc，此时array2指向的对象1岁
        array3 = new byte[2*_1MB];
        array3 = new byte[2*_1MB];

        array3 = null;

        byte[] array4 = new byte[2*_1MB];//第二次minor gc，此时array2指向的对象2岁
        array4 = new byte[2*_1MB];
        array4 = new byte[2*_1MB];
        array4 = null;

        byte[] array5 = new byte[2*_1MB];//第三次minor gc，此时array2指向的对象3岁



    }

    /**
     * survivor空间不足
     * 问题：是不是所有对象都进入老年代？
     * A：不是
     */
    public static void survivor_area(){
        //jvm配置：-XX:NewSize=10m -XX:MaxNewSize=10m -XX:InitialHeapSize=20m -XX:MaxHeapSize=20m -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=10m -XX:MaxTenuringThreshold=15 -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc4.log

        byte[] array1 = new byte[2*_1MB];
        array1 = new byte[2*_1MB];
        array1 = new byte[2*_1MB];

        byte[] array2 = new byte[128*1024];
        array2 = null;


        byte[] array3 = new byte[2*_1MB];//这里触发第一次minor gc
    }
}

