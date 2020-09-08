package com.hailintang.demo.template.BFS;

import com.hailintang.demo.template.BFSTemplate;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Description:
 * @Author: tanghailin
 * @Date: 2020/9/4 6:06 下午
 */
public class MinDepth {

    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();//核心数据结构

        Set<TreeNode> visited = new HashSet<>();//避免走回头路

        queue.add(root);//将起点加入队列

        visited.add(root);

        int step = 1;   //记录扩散的步数

        while(!queue.isEmpty()){
            int size = queue.size();

            //将队列中的所有节点向四周扩散

            for(int i=0;i<size;i++){
                TreeNode cur = queue.poll();
                //划重点：这里判断是否到达终点
                if(cur!=null&&cur.left==null&&cur.right==null){
                    return step;
                }
                //将cur相邻的节点都加入队列
                addNodeToQueue(cur,queue,visited);
            }
            //更新步数
            step++;
        }
        return step;
    }

    private void addNodeToQueue(TreeNode cur, Queue<TreeNode> queue, Set<TreeNode> visited) {
        if(cur!=null&&cur.left!=null&&!visited.contains(cur.left)){
            queue.add(cur.left);
            visited.add(cur.left);
        }

        if(cur!=null&&cur.right!=null&&!visited.contains(cur.right)){
            queue.add(cur.right);
            visited.add(cur.right);
        }
    }

}
