package com.hailintang.demo.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * @Author Hailin.Tang
 * @Date 2020-02-11 17:42
 */
public class Chinese_94 {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int data) {
            this.val = data;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || cur!=null){
            if(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }else {
                TreeNode pop = stack.pop();
                list.add(pop.val);
                cur = cur.right;
            }
        }
        return list;
    }
}