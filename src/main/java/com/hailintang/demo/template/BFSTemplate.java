package com.hailintang.demo.template;

import com.hailintang.demo.template.BFS.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Description: BFS模板
 * @Author: tanghailin
 * @Date: 2020/9/4 5:53 下午
 */
public class BFSTemplate {



    public int BFS(TreeNode start, TreeNode end){
        Queue<TreeNode> queue = new LinkedList<>();//核心数据结构

        Set<TreeNode> visited = new HashSet<>();//避免走回头路

        queue.add(start);//将起点加入队列

        visited.add(start);

        int step = 0;   //记录扩散的步数

        while(!queue.isEmpty()){
            int size = queue.size();

            //将队列中的所有节点向四周扩散

            for(int i=0;i<size;i++){
                TreeNode cur = queue.poll();
                //划重点：这里判断是否到达终点
                if(cur == end){
                    return step;
                }

                //将cur相邻的节点都加入队列
                for(TreeNode x : cur.adj()){
                    if(!visited.contains(x)){
                        queue.offer(x);
                        visited.add(x);
                    }
                }
            }
            //更新步数
            step++;
        }
        return step;
    }
}
