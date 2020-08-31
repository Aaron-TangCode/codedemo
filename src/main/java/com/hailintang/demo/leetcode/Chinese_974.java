package com.hailintang.demo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hailin.tang
 * @date 2020/5/27 4:28 下午
 * @function
 */
public class Chinese_974 {
    public static void main(String[] args) {
        int[] arr = new int[]{4,5,0,-2,-3,1};
        int i = subarraysDivByK2(arr, 5);
        System.out.println(i);
    }
    public static int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);
        int sum = 0, ans = 0;
        for (int elem : A) {
            //前缀和
            sum += elem;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int modulus = (sum % K + K) % K;
            int same = record.getOrDefault(modulus, 0);
            ans += same;
            record.put(modulus, same + 1);
        }
        return ans;
    }
    public static int subarraysDivByK2(int[] A, int K) {
        int res = 0;
        int sum;
        for(int i=0;i<A.length;i++){
            sum = 0;
            for(int j=i;j<A.length;j++){
                sum = sum + A[j];
                if((sum%K+K)%K==0){
                    res++;
                }
            }
        }
        return res;
    }
}
