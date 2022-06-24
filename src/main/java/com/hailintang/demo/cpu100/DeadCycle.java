package com.hailintang.demo.cpu100;

public class DeadCycle {
    public static void main(String[] args) {
        int i = 0;
        while (true){
            System.out.println("死循环进行中,次数:"+i++);
        }
    }
}
