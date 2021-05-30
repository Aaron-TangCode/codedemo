package com.hailintang.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Chinese_9986 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> res = new ArrayList<>();
        //双指针
        int i = 0;
        int j = 0;
        while(i<A.length&&j<B.length){
            int a1 = A[i][0];
            int a2 = A[i][1];
            int b1 = B[j][0];
            int b2 = B[j][1];

            if(!(a2<b1 || b2<a1)){
                //有交集，取交集条件
                res.add(new int[]{Math.max(a1,b1),Math.min(a2,b2)});
            }
//            if(a2>=b1 && b2>=a1){
//                //有交集，取交集条件
//                res.add(new int[]{Math.max(a1,b1),Math.min(a2,b2)});
//            }

            //移动指针
            if(a2>b2){
                j++;
            }else{
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
