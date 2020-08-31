package com.hailintang.demo.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hailin.tang
 * @date 2020/7/11 9:19 下午
 * @function 广度优先遍历
 */
public class BFS {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    //用双端队列
    public static void bfs(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            System.out.println(node.val);

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
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

        bfs(node3);
    }
}
