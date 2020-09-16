package com.hailintang.demo.template.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 无重复最长子串
 * @Author: tanghailin
 * @Date: 2020/9/8 2:25 下午
 */
public class LongestSubstringWithoutRepeating {
    /**
     * 输入长度
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> window = new HashMap<>();

        char[] chars = s.toCharArray();

        int left = 0;
        int right = 0;
        int res = 0;
        while(right<chars.length){
            char c = chars[right];
            right++;
            if(window.containsKey(c)){
                window.put(c,window.get(c)+1);
            }else{
                window.put(c,1);
            }
            //有重复元素
            while(window.get(c)>1){
                char d = chars[left];
                left++;
                window.put(d,window.get(d)-1);
            }
            res = Math.max(res,right-left);
        }

        return res;
    }

    /**
     * 输出最长不重复子串
     * @param s
     * @return
     */
    public String lengthOfLongestSubstring2(String s) {
        Map<Character,Integer> window = new HashMap<>();

        char[] chars = s.toCharArray();

        int left = 0;
        int right = 0;
        int start = 0;
        int end = 0;
        int resNum = 0;
        String res = null;
        while(right<chars.length){
            char c = chars[right];
            right++;
            if(window.containsKey(c)){
                window.put(c,window.get(c)+1);
            }else{
                window.put(c,1);
            }
            //有重复元素
            while(window.get(c)>1){
                char d = chars[left];
                left++;
                window.put(d,window.get(d)-1);
            }
            resNum = Math.max(resNum,right-left);

        }

        return s.substring(end-resNum,end);
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        LongestSubstringWithoutRepeating longestSubstringWithoutRepeating = new LongestSubstringWithoutRepeating();
        int length = longestSubstringWithoutRepeating.lengthOfLongestSubstring(s);
        String res = longestSubstringWithoutRepeating.lengthOfLongestSubstring2(s);
        System.out.println(length);
        System.out.println(res);
    }
}
