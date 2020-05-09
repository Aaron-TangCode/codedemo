package com.hailintang.demo.suanfa;

import java.util.Arrays;

/**
 * @author hailin.tang
 * @date 2020-04-09 22:38
 * @function
 */
public class TestZ {
    public static void main(String[] args) {
        convert("LEETCODEISHIRING", 4);
        System.out.println("IMAGE_ppx_6804380828202703111".hashCode()%512);
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        String[] arr = new String[numRows];
        Arrays.fill(arr, "");
        char[] chars = s.toCharArray();
        int len = chars.length;
        int period = numRows * 2 - 2;
        for (int i = 0; i < len; i++) {
            int mod = i % period;
            if (mod < numRows) {
                arr[mod] += chars[i];
            } else {
                arr[period - mod] += String.valueOf(chars[i]);
            }
        }
        StringBuilder res = new StringBuilder();
        for (String ch : arr) {
            res.append(ch);
        }
        return res.toString();
    }
}
