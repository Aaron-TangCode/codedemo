package com.hailintang.demo.sort;

import java.util.Arrays;

/**
 * @author hailin.tang
 * @date 2020/5/9 1:07 下午
 * @function 计数排序
 * 特点：是统计排序，速度比任何比较排序都快。但需要确定整数范围。因为需要借助辅助空间
 */
public class CountingSort {
    public static int[] doCountSort(int[] arr){
        //排序：保证原数组不被影响
        int[] newArr = Arrays.copyOf(arr,arr.length);
        //找大最大值，为了分配数组长度
        int maxValue = getMaxValue(newArr);
        int[] count = new int[maxValue+1];
        //进行排序
        for (int i = 0; i < newArr.length; i++) {
            count[newArr[i]]++;
        }

        // 让count按顺序吐元素出来
        int[] res = new int[newArr.length];
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            //如果count[i]数值大于0，就赋值给res,然后count[i]--
            while (count[i]>0){
                res[index++] = i;
                count[i]--;
            }
        }
        return res;
    }

    private static int getMaxValue(int[] newArr) {
        if(newArr==null){
            return 0;
        }
        int maxValue = newArr[0];
        for (int i = 1; i < newArr.length; i++) {
            if(maxValue<newArr[i]){
                maxValue = newArr[i];
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,2,4,0,1,6,9};
        int[] result = doCountSort(arr);
        for (int i : result) {
            System.out.print(i+" ");
        }
    }
}
