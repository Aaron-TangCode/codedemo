package com.hailintang.demo.leetcode;

/**
 * @author hailin.tang
 * @date 2020/7/14 11:49 上午
 * @function
 */
public class Chinese_231 {
    public static boolean isPowerOfTwo(int n) {
        //1:1 2的0次方
        //2:10
        //4:100
        //8:1000
        //综上，只有一个1
        //方法1：n&(n-1) 去除最右边的1
        //方法2：对2取余,时间复杂度O(logN)
        //方法3：n&(-n) 获取最右边的1
        if(n==0){
            return false;
        }
        int x =  n;
        if((x&(-x))==x){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean powerOfTwo = isPowerOfTwo(-2147483648);
        System.out.println(powerOfTwo);
    }
}
