package com.hailintang.demo.xuetang;

import java.util.Random;

/**
 * @author hailin.tang
 * @date 2020/4/21 5:22 下午
 * @function
 */
public class TestHailStone {
    public static void main(String[] args) {
        Random random = new Random();
        int n = 1000000;
        while(n-->0){
            int num = random.nextInt(500000);
            int res = testHailStone(num);
            System.out.println("length: "+res);
        }
        System.out.println("finished");
    }
    public static int testHailStone(int n){
        int length = 1;
        while(n>1){
            if(n%2==0){
                n = n/2;
            }else{
                n = 3*n+1;
            }
            length++;
        }
        return length;
    }
}
