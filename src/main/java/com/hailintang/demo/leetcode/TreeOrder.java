package com.hailintang.demo.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author hailin.tang
 * @date 2020/7/12 6:42 下午
 * @function 深度优先遍历（前中后序遍历）、广度优先遍历
 */
public class TreeOrder {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.left = createBinaryTree(inputList);
            node.right = createBinaryTree(inputList);
        }
        return node;
    }

    public static void preOrderTraveral(TreeNode node){
        if(node==null){
            return;
        }

        System.out.println(node.val);
        preOrderTraveral(node.left);
        preOrderTraveral(node.right);
    }

    public static void inOrderTraveral(TreeNode node){
        if(node==null){
            return;
        }

        inOrderTraveral(node.left);
        System.out.println(node.val);
        inOrderTraveral(node.right);
    }

    public static void postOrderTraveral(TreeNode node){
        if(node==null){
            return;
        }

        postOrderTraveral(node.left);
        postOrderTraveral(node.right);
        System.out.println(node.val);
    }
    //用遍历实现前序遍历
    public static void preOrderErgodic(TreeNode node){
        if(node==null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();

        while(node!=null||!stack.isEmpty()){
            //如果左节点不为空，就压栈
            while (node!=null){
                System.out.println(node.val);
                stack.push(node);
                node = node.left;
            }

            if(!stack.isEmpty()){
                TreeNode pop = stack.pop();
                node = pop.right;
            }
        }
    }

    public static void inOrderEdgodic(TreeNode node){
        if(node==null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(node!=null||!stack.isEmpty()){
            while(node!=null){
                stack.push(node);
                node = node.left;
            }

            if(!stack.isEmpty()){
                TreeNode pop = stack.pop();
                System.out.println(pop.val);
                node = pop.right;
            }
        }
    }

    public static void postOrderEdgodic(TreeNode node){
        if(node==null){
            return;
        }
        TreeNode cur;
        TreeNode pre = null;
        cur = node;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(cur);
        while(!stack.isEmpty()){
            cur = stack.peek();
            //要么左右节点都为空，要么上一个节点是当前节点的左节点或右节点
            if((cur.left==null&&cur.right==null)||(pre!=null&&(pre==cur.left||pre==cur.right))){
                TreeNode pop = stack.pop();
                System.out.println(pop.val);
                pre = pop;
            }else{
                if(cur.right!=null){
                    stack.push(cur.right);
                }
                if(cur.left!=null){
                    stack.push(cur.left);
                }
            }
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new
                LinkedList<>(Arrays.asList(new Integer[]{
                        3,2,9,null,null,10,null,null,8,null,4
        }));
        TreeNode root = createBinaryTree(inputList);
        System.out.println("前序遍历（递归）：");
        preOrderTraveral(root);
        System.out.println("前序遍历（遍历）：");
        preOrderErgodic(root);

        System.out.println("中序遍历（递归）：");
        inOrderTraveral(root);
        System.out.println("中序遍历（遍历）：");
        inOrderEdgodic(root);

        System.out.println("后序遍历（递归）：");
        postOrderTraveral(root);

        System.out.println("后序遍历（遍历）：");
        postOrderEdgodic(root);

    }
}
