package com.hailintang.demo.leetcode;

import java.util.*;

/**
 * @author hailin.tang
 * @date 2020/7/9 12:57 下午
 * @function
 */
public class Chinese_20 {
    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        Set<Character> left = new HashSet<>();
        Map<Character, Character> map = new HashMap<>();
        left.add('(');
        left.add('[');
        left.add('{');
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            //遇到左括号，入栈push
            if (left.contains(aChar)) {
                stack.push(map.get(aChar));
            } else {//遇到右括号，peek匹配，就poll.不匹配，就return false
                if (stack.size() > 0 && aChar == stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        //最后判断stack是否为空，空就返回true。非空就返回false
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "]";
        boolean valid = isValid(s);
        System.out.println(valid);
    }
}
