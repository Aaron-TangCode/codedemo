package com.hailintang.demo.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * @Author Hailin.Tang
 * @Date 2020-02-11 17:31
 */
public class Chinese_144 {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int data) {
            this.val = data;
        }
    }

    public List<Integer> preOrderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(cur);
        while(!stack.isEmpty()){
            cur = stack.pop();
            list.add(cur.val);
            if(cur.right!=null){
                stack.push(cur.right);
            }
            if(cur.left!=null){
                stack.push(cur.left);
            }
        }
        return list;
    }
}
