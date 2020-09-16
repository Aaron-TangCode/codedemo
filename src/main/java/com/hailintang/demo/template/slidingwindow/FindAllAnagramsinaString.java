package com.hailintang.demo.template.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 找所有字母的异位词。异位词：指字母相同，但排列不同，就是顺序不同
 * @Author: tanghailin
 * @Date: 2020/9/8 11:15 上午
 */
public class FindAllAnagramsinaString {
    /**
     * 问题1：移动right指针时，要更新哪些数据
     * D：更新window和valid
     * 问题2：移动Left指针是，要更新哪些数据
     * D：更新window和valid
     * 问题3：什么时候停止right,开始移动left？
     * D:right-left>=target.length
     * 问题4：数据结果的更新，是在right移动时，还是在left移动？
     * D:left
     * @param s:长
     * @param p：短
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character,Integer> needs = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        //初始化
        char[] target = p.toCharArray();
        char[] source = s.toCharArray();
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
        int valid = 0;

        //遍历
        while(right<source.length){
            char c = source[right];

            right++;

            if(needs.containsKey(c)){
                window.put(c,window.get(c)+1);
                if(needs.get(c).equals(window.get(c))){
                    valid++;
                }
            }


            //left移动
            while(right-left>=target.length){
                if(valid==needs.size()){
                    res.add(left);
                }
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

        return res;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        FindAllAnagramsinaString findAllAnagramsinaString = new FindAllAnagramsinaString();
        List<Integer> anagrams = findAllAnagramsinaString.findAnagrams(s, p);
        System.out.println(anagrams);
    }
}
