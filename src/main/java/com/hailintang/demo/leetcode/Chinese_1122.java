package com.hailintang.demo.leetcode;

import java.util.*;

/**
 * @author Aaron
 * @date 2020-02-03 16:32
 * @function 题目链接：https://leetcode-cn.com/problems/relative-sort-array/
 */
public class Chinese_1122 {
    /**
     * 计数排序
     * @param arr1
     * @param arr2
     * @return
     */
    public static int[] relativeSortArray2(int[] arr1,int[] arr2){
        int[] acount = new int[1001];//因为说题目标明数字范围是0-1000
        int[] result = new int[arr1.length];//结果数组
        //把数据放入桶中
        for (int i = 0; i < arr1.length; i++) {
            acount[arr1[i]] = ++acount[arr1[i]];
        }
        int index = 0;
        //根据arr2排序，把数据放在result数组
        for (int i = 0; i < arr2.length; i++) {
            while(acount[arr2[i]]>0){
                result[index++] = arr2[i];
                acount[arr2[i]]--;
            }
        }

        //遍历arr1剩下的元素
        for (int i = 0; i < acount.length; i++) {
            while(acount[i]>0){
                result[index++] = i;
                acount[i]--;
            }
        }

        return result;
    }

    /**
     * 暴力方法
     * 时间复杂度：O(N^2)
     * 空间复杂度：O（N）
     * @param arr1
     * @param arr2
     * @return
     */
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] temp = new int[arr1.length];
        //备份
        for (int i = 0; i < arr1.length; i++) {
            temp[i] = arr1[i];
        }
        Map<Integer,Integer> map = new LinkedHashMap<>();
        //初始化
        for (int i : arr2) {
            map.put(i,0);
        }
        //遍历arr2,用map存arr1的次数，和相对顺序
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if(arr2[i]==arr1[j]){
                    Integer count = map.get(arr2[i]);
                    map.put(arr2[i],++count);
                    //标记位
                    arr1[j] = -1;
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        //遍历map,放在res中
        Set<Integer> keySet = map.keySet();
        Iterator<Integer> iterator = keySet.iterator();
        while(iterator.hasNext()){
            Integer key = iterator.next();
            Integer value = map.get(key);
            for(int i=0;i<value;i++){
                list.add(key);
            }
        }
        //对arr1升序排列
        Arrays.sort(arr1);
        //处理arr1剩下的元素，不在arr2下的元素
        for (int i : arr1) {
            if(i!=-1){
                list.add(i);
            }
        }
        //list转数组
        int[] res = new int[arr1.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        arr1 = temp;
        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = new int[]{2,1,4,3,9,6};

//        int[] res = relativeSortArray(arr1, arr2);
//        printArr(res);
        int[] res2 = relativeSortArray2(arr1,arr2);
        printArr(res2);
    }

    private static void printArr(int[] arr){
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
