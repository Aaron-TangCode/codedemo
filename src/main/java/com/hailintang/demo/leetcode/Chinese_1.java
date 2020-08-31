package com.hailintang.demo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hailin.tang
 * @date 2020/7/9 9:05 下午
 * @function
 */
public class Chinese_1 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            map.remove(nums[i]);
            if(map.containsKey(target-nums[i])){
                res[0] = i;
                res[1] = map.get(target-nums[i]);
                break;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4};
        int[] ints = twoSum(nums, 6);
        System.out.println(ints.toString());
    }
}
