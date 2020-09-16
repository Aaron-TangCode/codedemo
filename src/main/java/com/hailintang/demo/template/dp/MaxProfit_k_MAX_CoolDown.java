package com.hailintang.demo.template.dp;

/**
 * @Description: 股票交易，无限次交易，有冷却器
 * @Author: tanghailin
 * @Date: 2020/9/15 11:53 上午
 */
public class MaxProfit_k_MAX_CoolDown {

    /**
     * 时间复杂度O(N),额外空间复杂度：O(1)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0){
            return 0;
        }
        //转态转移方程 state equation。状态：1、天数，2、最多购买次数（这里次数是1，可不用额外开空间），3、持有.
        int n = prices.length;
        /**
         * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
         * dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i])
         * 有冷却期
         * 解释：第 i 天选择 buy 的时候，要从 i-2 的状态转移，而不是 i-1 。
         */
        int dp_i_0 = 0;////因为-1表示还没开始，没持有股票，这时候利润为0
        int dp_i_1 = Integer.MIN_VALUE;//Integer.MIN_VALUE; 不允许交易的情况下，是不可能持有股票的，用负无穷表示不可能
        int dp_pre_0 = 0;//代表dp[i-2][0]
        //base case
//        dp[-1][k][0] = 0;//因为-1表示还没开始，没持有股票，这时候利润为0
//        dp[-1][k][1] = Integer.MIN_VALUE;//因为-1表示还没开始，就持有股票，用负无穷表示不可能
//        dp[i][0][0] = 0; 因为K是从1开始的，K为0，意味不可以交易，那利润为0
//        dp[i][0][1] = Integer.MIN_VALUE; 不允许交易的情况下，是不可能持有股票的，用负无穷表示不可能
        for (int i=0;i<n;i++){
            //今天不持有股票=max(昨天不持有股票（休息），昨天持有股票，但卖了)
            int temp = dp_i_0;
            int rest0 = dp_i_0;
            int sell = dp_i_1+prices[i];
            int rest1 = dp_i_1;
            int buy = dp_pre_0-prices[i];
            dp_i_0 = Math.max(rest0,sell);
            //今天持有股票=max(昨天持有股票（休息），昨天不持有股票，但买了)
            dp_i_1 = Math.max(rest1,buy);
            dp_pre_0 = temp;
        }

        return dp_i_0;
    }

    public static void main(String[] args) {
//        int[] prices = new int[]{3,2,6,5,0,3};
        int[] prices = new int[]{2,1,2,0,1};
        MaxProfit_k_MAX_CoolDown maxProfitK1 = new MaxProfit_k_MAX_CoolDown();
        int maxProfit = maxProfitK1.maxProfit(prices);
        System.out.println(maxProfit);
    }
}
