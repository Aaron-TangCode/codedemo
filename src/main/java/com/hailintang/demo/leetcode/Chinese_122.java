package com.hailintang.demo.leetcode;

/**
 * @author hailin.tang
 * @date 2020/7/11 1:35 下午
 * @function
 */
public class Chinese_122 {
    public static int maxProfit(int[] prices) {
        int res = 0;
        for(int i=0;i<prices.length;i++){
            //如果后一天，比前一天股价高，买入
            if(i+1<prices.length&&prices[i]<prices[i+1]){
                res += (prices[i+1] - prices[i]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7,1,5,3,6,4};
        int maxProfit = maxProfit(arr);

        System.out.println(maxProfit);
    }
}
