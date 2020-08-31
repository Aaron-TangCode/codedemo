package com.hailintang.demo.leetcode;

import java.util.LinkedList;

/**
 * @author hailin.tang
 * @date 2020/7/11 11:24 下午
 * @function
 */
public class Chinese_239 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        //1、队列存的是数组的下标
        //2、窗口要保持从大到小顺序
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            //保持从大到小的顺序
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            //加入队列
            queue.addLast(i);
            //去除过期值
            if (queue.peek() < i - k) {
                queue.poll();
            }

            //统计结果
            if (i + 1 >= k) {
                res[i+1- k] = nums[queue.peek()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{1,3,-1,-3,5,3,6,7};
//        int[] ints = maxSlidingWindow(arr,3);
//        for (int a : ints) {
//            System.out.print(a+",");
//        }
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        System.out.println(queue);
        System.out.println(queue.peekFirst());
        System.out.println(queue.peekLast());
        queue.add(3);
        System.out.println(queue);
        System.out.println(queue.peekFirst());
        System.out.println(queue.peekLast());
    }
}
