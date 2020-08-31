package com.hailintang.demo.leetcode;

/**
 * @author hailin.tang
 * @date 2020/7/14 11:07 上午
 * @function
 */
public class Chinese_191 {
    public int hammingWeight(int n) {
        int res = 0;
        //中间操作
        while (n!=0){
            res++;
            n = n&(n-1);
        }
        return res;
    }
}
