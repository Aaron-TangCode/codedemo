package com.hailintang.demo.leetcode;

import java.lang.ref.PhantomReference;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hailin.tang
 * @date 2020/7/12 3:19 下午
 * @function
 */
public class Chinese_46 {
    static List<List<Integer>> res = new LinkedList<>();

    public static List<List<Integer>> permute(int[] nums) {
        //记录路径
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);

        return res;
    }

    public static void backtrack(int[] nums, LinkedList<Integer> track) {
        //触发结束条件:到底部时，就结束
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //排除不合法的选择
            if(track.contains(nums[i])){
                continue;
            }
            //做选择
            track.add(nums[i]);
            backtrack(nums,track);

            //撤销选择
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> permute = permute(nums);
        System.out.println(permute);
    }
}
