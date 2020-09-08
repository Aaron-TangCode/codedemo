package com.hailintang.demo.template.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Description:
 * @Author: tanghailin
 * @Date: 2020/9/4 7:11 下午
 */
public class OpenLock {

    public int openLock(String[] deadends, String target){
        //记录需要跳过的死亡代码
        Set<String> deads = new HashSet<>();

        for (String s:deadends){
            deads.add(s);
        }

        //记录已经穷举过的密码，防止走回头路

        Set<String> visited = new HashSet<>();

        Queue<String> queue = new LinkedList<>();

        int step = 0;
        queue.add("0000");
        visited.add("0000");

        while(!queue.isEmpty()){
            int size = queue.size();
            //将队列中的所有节点向周围扩展
            for(int i=0;i<size;i++){
                String cur = queue.poll();

                if(deads.contains(cur)){
                    continue;
                }
                //到达终点
                if(cur.equals(target)){
                    return step;
                }


                //将一个节点的未遍历相邻节点加入队列
                for(int j = 0;j<4;j++){
                    String up = plusOne(cur,j);
                    if(!visited.contains(up)){
                        queue.offer(up);
                        visited.add(up);
                    }

                    String down = minusOne(cur, j);
                    if(!visited.contains(down)){
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }
    // 将 s[j] 向上拨动一次
    String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9')
            ch[j] = '0';
        else
            ch[j] += 1;
        return new String(ch);
    }
    // 将 s[i] 向下拨动一次
    String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0')
            ch[j] = '9';
        else
            ch[j] -= 1;
        return new String(ch);
    }
}
