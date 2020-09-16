package com.hailintang.demo.template.dp;

/**
 * @Description: 股票交易，最多交易K次，K==1
 * @Author: tanghailin
 * @Date: 2020/9/15 11:53 上午
 */
public class MaxProfit_k_1 {
    /**
     * 时间复杂度O(N),额外空间复杂度：O(N)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0){
            return 0;
        }
        //转态转移方程 state equation。状态：1、天数，2、最多购买次数（这里次数是1，可不用额外开空间），3、持有.
        int n = prices.length;

        int[][] dp = new int[n][2];
        //base case
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
//        dp[-1][k][0] = 0;//因为-1表示还没开始，没持有股票，这时候利润为0
//        dp[-1][k][1] = Integer.MIN_VALUE;//因为-1表示还没开始，就持有股票，用负无穷表示不可能
//        dp[i][0][0] = 0; 因为K是从1开始的，K为0，意味不可以交易，那利润为0
//        dp[i][0][1] = Integer.MIN_VALUE; 不允许交易的情况下，是不可能持有股票的，用负无穷表示不可能
        for (int i=1;i<n;i++){
            //今天不持有股票=max(昨天不持有股票（休息），昨天持有股票，但卖了)
            int rest0 = dp[i-1][0];
            int sell = dp[i-1][1]+prices[i];
            int rest1 = dp[i-1][1];
            int buy = -prices[i];
            dp[i][0] = Math.max(rest0,sell);
            //今天持有股票=max(昨天持有股票（休息），昨天不持有股票，但买了)
            dp[i][1] = Math.max(rest1,buy);
        }

        return dp[n-1][0];
    }


    /**
     * 时间复杂度O(N),额外空间复杂度：O(1)
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if(prices==null||prices.length==0){
            return 0;
        }
        //转态转移方程 state equation。状态：1、天数，2、最多购买次数（这里次数是1，可不用额外开空间），3、持有.
        int n = prices.length;

        int dp_i_0 = 0;////因为-1表示还没开始，没持有股票，这时候利润为0
        int dp_i_1 = Integer.MIN_VALUE;//Integer.MIN_VALUE; 不允许交易的情况下，是不可能持有股票的，用负无穷表示不可能
        //base case
//        dp[-1][k][0] = 0;//因为-1表示还没开始，没持有股票，这时候利润为0
//        dp[-1][k][1] = Integer.MIN_VALUE;//因为-1表示还没开始，就持有股票，用负无穷表示不可能
//        dp[i][0][0] = 0; 因为K是从1开始的，K为0，意味不可以交易，那利润为0
//        dp[i][0][1] = Integer.MIN_VALUE; 不允许交易的情况下，是不可能持有股票的，用负无穷表示不可能
        for (int i=0;i<n;i++){
            //今天不持有股票=max(昨天不持有股票（休息），昨天持有股票，但卖了)
            int rest0 = dp_i_0;
            int sell = dp_i_1+prices[i];
            int rest1 = dp_i_1;
            int buy = -prices[i];
            dp_i_0 = Math.max(rest0,sell);
            //今天持有股票=max(昨天持有股票（休息），昨天不持有股票，但买了)
            dp_i_1 = Math.max(rest1,buy);
        }

        return dp_i_0;
    }

    public static void main(String[] args) {
//        int[] prices = new int[]{3,2,6,5,0,3};
        int[] prices = new int[]{2,1,2,0,1};
        MaxProfit_k_1 maxProfitK1 = new MaxProfit_k_1();
        int maxProfit = maxProfitK1.maxProfit(prices);
        int maxProfit2 = maxProfitK1.maxProfit2(prices);
        System.out.println(maxProfit);
        System.out.println(maxProfit2);
    }
}
