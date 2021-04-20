package com.hailintang.demo.jdk8;

public class TestCPU {
    public static void main(String[] args) {
        int[][] arr = new int[10000][10000];

        //按行遍历
        long start = System.currentTimeMillis();
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(1==1){

                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("行遍历时间:"+(end-start));
        //按列遍历
        start = System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            for(int j=0;j<arr.length;j++){
                if(1==1){

                }
            }
        }
        end = System.currentTimeMillis();
        System.out.println("列遍历时间:"+(end-start));

    }

}
