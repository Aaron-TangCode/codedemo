package com.hailintang.demo.suanfa;

/**
 * @author hailin.tang
 * @date 2020/5/26 3:37 下午
 * @function
 * 第一步：检查1，是否存在，如果不存在，就是1
 * 第二步：如果1存在，并且长度为1，就是2
 * 第三步：把负数，0，大于数据长度n的数，都替换为1
 * 第四步：根据i，把i位置的数变为负数
 */
public class TestFirstNum {
    public static void main(String[] args) {
//        int[] arr = new int[]{1,2,0};
        int[] arr = new int[]{4,1,-1,2,1,5,16,0,2,0,5,13,-7};
        int i = firstMissingPositive(arr);
        int j = firstMissingPositive2(arr);
        System.out.println(i==j);
    }

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // 基本情况
        int contains = 0;
        for (int i = 0; i < n; i++)
            if (nums[i] == 1) {
                contains++;
                break;
            }

        if (contains == 0)
            return 1;

        // nums = [1]
        if (n == 1)
            return 2;

        // 用 1 替换负数，0，
        // 和大于 n 的数
        // 在转换以后，nums 只会包含
        // 正数
        for (int i = 0; i < n; i++)
            if ((nums[i] <= 0) || (nums[i] > n))
                nums[i] = 1;

        // 使用索引和数字符号作为检查器
        // 例如，如果 nums[1] 是负数表示在数组中出现了数字 `1`
        // 如果 nums[2] 是正数 表示数字 2 没有出现
        for (int i = 0; i < n; i++) {
            int a = Math.abs(nums[i]);
            // 如果发现了一个数字 a - 改变第 a 个元素的符号
            // 注意重复元素只需操作一次
            if (a == n)
                nums[0] = -Math.abs(nums[0]);
            else
                nums[a] = -Math.abs(nums[a]);
        }

        // 现在第一个正数的下标
        // 就是第一个缺失的数
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0)
                return i;
        }

        if (nums[0] > 0)
            return n;

        return n + 1;
    }


    public static int firstMissingPositive2(int[] nums){
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1])//最多N次交换
                swap(nums,i, nums[i] - 1);
        }

        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1)
                return i + 1;
        }

        return n + 1;
    }

    private static void swap(int[] nums,int num, int num1) {
        int temp = nums[num];
        nums[num] = nums[num1];
        nums[num1] = temp;
    }
}
