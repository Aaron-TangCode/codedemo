package com.hailintang.demo.leetcode;

import java.util.Arrays;

/*
是一个圈，【1，2，3，4】中的1，4是相邻的，也就是不能一起偷了
三种情况：
1、两个都不偷
2、偷第一个，不偷最后一个
3、不偷第一个，偷最后一个
其实不用看第一种情况，因为第2，3种情况肯定比第1种情况好，因为数值是非负数。
 */
public class Chinese_213 {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }

        return Math.max(dp(nums,0,n-2),dp(nums,1,n-1));
    }

    public int dp(int[] nums,int start,int end){
        int[] dp = new int[end+3];
//        dp[0] = 0;
        for (int i = end; i >= start; i--) {
            dp[i] = Math.max(dp[i+1],nums[i]+dp[i+2]);
        }
        return dp[start];

    }

    public static void main(String[] args) {
        Chinese_213 chinese_213 = new Chinese_213();
        int[] arr = new int[]{1,2};
        System.out.println(chinese_213.rob(arr));
    }
}
