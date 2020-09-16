package com.hailintang.demo.template.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 字符串的排列。leetcode567
 * @Author: tanghailin
 * @Date: 2020/9/8 10:34 上午
 */
public class PermutationinString {
    /**
     * 问题1：移动right指针时，要更新哪些数据
     * D：更新window和valid
     * 问题2：移动Left指针是，要更新哪些数据
     * D：更新window和valid
     * 问题3：什么时候停止right,开始移动left？
     * D:right-left>=needs.size
     * 问题4：数据结果的更新，是在right移动时，还是在left移动？
     * D:right
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> needs = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();

        //初始化
        char[] target = s1.toCharArray();
        char[] source = s2.toCharArray();
        for (char c : target) {
            if(needs.containsKey(c)){
                needs.put(c,needs.get(c)+1);
            }else{
                needs.put(c,1);
            }
            window.put(c,0);
        }
        int left = 0;
        int right = 0;
        int valid = 0;//valid表示窗口中满足needs条件的字符个数
        //左臂右开
        while(right<s2.length()){
            //向右移动
            char c = source[right];

            right++;

            if(needs.containsKey(c)){
                window.put(c,window.get(c)+1);
                if(needs.get(c).equals(window.get(c))){
                    valid++;
                }
            }

            if(valid==needs.size()){
                return true;
            }

            while(right-left>=target.length){

                char d = source[left];

                left++;

                if(needs.containsKey(d)){
                    if(needs.get(d).equals(window.get(d))){
                        valid--;
                    }
                    window.put(d,window.get(d)-1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        String source = "eidbaooo";
        String source = "abcdeabcdx";
//        String target = "ab";
        String target = "abcdxabcde";
        PermutationinString permutationinString = new PermutationinString();

        System.out.println(permutationinString.checkInclusion(target, source));
    }
}
