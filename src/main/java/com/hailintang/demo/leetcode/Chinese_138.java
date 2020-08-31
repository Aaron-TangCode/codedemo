package com.hailintang.demo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aaron
 * @date 2020-02-07 14:48
 * @function 题目链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 */
public class Chinese_138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public static void main(String[] args) {

    }

    /**
     * 方式1：用哈希表
     * @param head
     * @return
     */
    public Node copyRandomList1(Node head) {
        Map<Node,Node> map = new HashMap<>();
        //遍历链表，生成新节点
        Node cur = head;
        Node next = null;
        while(cur != null){
            next = cur.next;
            map.put(cur,new Node(cur.val));
            cur = next;
        }
        cur = head;
        //连接新节点
        while(cur!=null){
            next = cur.next;
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = next;
        }
        return map.get(head);
    }

    /**
     * 方式2：时间复杂度O(n),额外空间复杂度O(1)
     * @param head
     * @return
     */
    public Node copyRandomList2(Node head) {
        if(head==null){
            return null;
        }
        Node cur = head;
        Node next = null;
        //复制新链表，只复制next指针，不复制random指针
        while(cur!=null){
            next = cur.next;
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = next;
        }
        cur = head;
        //复制random指针
        while(cur!=null){
            next = cur.next.next;
            cur.next.random = cur.random != null?cur.random.next:null;
            cur = next;
        }
        //把复制链表和源链表分开
        cur = head;
        Node newHead = cur.next;
        Node copyCur = null;
        while(cur!=null){
            //record the next node
            next = cur.next.next;
            copyCur = cur.next;
            cur.next = next;
            copyCur.next = next!=null?next.next:null;
            cur = next;
        }
        return newHead;
    }
}
