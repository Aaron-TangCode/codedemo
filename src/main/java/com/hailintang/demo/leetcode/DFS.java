package com.hailintang.demo.leetcode;

import java.util.Stack;

/**
 * @author hailin.tang
 * @date 2020/7/11 9:06 下午
 * @function 深度优先遍历
 */
public class DFS {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    //通过递归实现
    public static void dfs1(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);

        dfs1(root.left);
        dfs1(root.right);
    }

    //通过stack实现
    public static void dfs2(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val);
            //因为DFS是先打印左边，后打印右边。所以stack先入右孩子，后入左孩子
            if (node.right!=null) {
                stack.push(node.right);
            }

            if(node.left!=null){
                stack.push(node.left);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node15 = new TreeNode(15);
        TreeNode node20 = new TreeNode(20);

        node3.left = node9;
        node3.right = node20;
        node9.left = node8;
        node20.left = node15;
        node20.right = node7;

        dfs1(node3);
        System.out.println("====");
        dfs2(node3);
    }
}
