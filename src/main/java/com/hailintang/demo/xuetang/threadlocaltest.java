package com.hailintang.demo.xuetang;

import java.lang.ref.WeakReference;
import java.util.Arrays;

public class threadlocaltest{
    static int _4MB=1024*1024*4;
    static int _5MB=1024*1024*5;
    static int _6MB=1024*1024*6;
    static int _7MB=1024*1024*7;
    static int _8MB=1024*1024*8;
    static ThreadLocal<byte[]> local=new ThreadLocal<>();

    public static void main(String[] args){
        // WeakReference<int[]> weak1=new WeakReference<int[]>(new int[_4MB]);
       /* WeakReference<int[]> weak2=new WeakReference<int[]>(new int[_4MB]);
        WeakReference<int[]> weak3=new WeakReference<int[]>(new int[_4MB]);
        WeakReference<int[]> weak4=new WeakReference<int[]>(new int[_4MB]);*/
        local.set(new byte[_8MB*2]);
        System.gc();
        byte[] ints=local.get();
        System.out.println(ints);


        // byte []a=new byte[_4MB];
    }
}