package com.hailintang.demo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author hailin.tang
 * @date 2020/7/11 2:43 下午
 * @function
 */
public class Chinese_107 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();


        Queue<TreeNode> queue = new LinkedList<>();

        //加入头结点
        queue.add(root);

        while (!queue.isEmpty()) {
            //当前层的数量
            int size = queue.size();
            List<Integer> nums = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                nums.add(root.val);
                if (root.left != null) {
                    queue.add(root.left);
                }

                if (root.right != null) {
                    queue.add(root.right);
                }
            }
            //添加每一层的元素
            res.add(nums);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
