package com.hailintang.demo.template.dp;

/**
 * @Description:
 * @Author: tanghailin
 * @Date: 2020/9/8 6:17 下午
 */
public class MaxSumSubArray {
    public int maxSubArray(int[] nums){
        int n = nums.length;
        if (n == 0) return 0;
        int[] dp = new int[n];
        // 初始值
        dp[0] = nums[0];
        // 状态转移方程
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }
        // 得到 nums 的最大子数组
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{-1,8,-7,6,-10,-3,3,2};
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        MaxSumSubArray maxSumSubArray = new MaxSumSubArray();

        System.out.println(maxSumSubArray.maxSubArray(arr));
    }
}
