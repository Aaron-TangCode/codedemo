package com.hailintang.demo.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 打家劫舍
 * 状态：数组下标
 * 选择：打劫和不打劫
 */
public class Chinese_198 {
    int[] filter;
    public int rob(int[] nums) {
        filter = new int[nums.length];
        Arrays.fill(filter,-1);
        return dp(nums,0);
    }

    private int dp(int[] nums, int start) {
        if(start>=nums.length){
            return 0;
        }
        //去重
        if(filter[start]!=-1){
            return filter[start];
        }
        int res = Math.max(
                //不抢，下一家
                dp(nums,start+1),
                //抢，下下一家
                dp(nums,start+2)+nums[start]);
        filter[start] = res;
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,7,9,3,1};

        Chinese_198 chinese198 = new Chinese_198();
        System.out.println(chinese198.rob(arr));
    }
}
