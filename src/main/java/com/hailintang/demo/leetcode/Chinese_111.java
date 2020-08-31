package com.hailintang.demo.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author hailin.tang
 * @date 2020/7/11 10:14 下午
 * @function
 */
public class Chinese_111 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        int level = 0, minLevel = Integer.MAX_VALUE;
        stack.addLast(root);
        stack.addLast(root);
        while (!stack.isEmpty()) {
            root = stack.removeLast();
            if (root == stack.peekLast()) {
                level++;
                if (root.right != null) {
                    stack.addLast(root.right);
                    stack.addLast(root.right);
                }
                if (root.left != null) {
                    stack.addLast(root.left);
                    stack.addLast(root.left);
                }
            } else {
                if (root.left == null && root.right == null) {
                    minLevel = Math.min(minLevel, level);
                }
                level--;
            }
        }
        return minLevel;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.right = node5;

        System.out.println(minDepth(node1));
    }
}
