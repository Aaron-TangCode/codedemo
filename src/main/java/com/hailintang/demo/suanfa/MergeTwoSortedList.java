package com.hailintang.demo.suanfa;

/**
 * @author hailin.tang
 * @date 2020-04-14 13:18
 * @function
 */
public class MergeTwoSortedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n4 = new ListNode(4);
        ListNode v1 = new ListNode(1);
        ListNode v3 = new ListNode(3);
        ListNode v4 = new ListNode(4);
        n1.next = n2;
        n2.next = n4;

        v1.next = v3;
        v3.next = v4;

        ListNode listNode = mergeTwoLists(n1, v1);

    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // 记录头节点
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
                cur = cur.next;
            } else {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
                cur = cur.next;
            }
        }
        while (l1 != null) {
            cur.next = new ListNode(l1.val);
            l1 = l1.next;
            cur = cur.next;
        }

        while (l2 != null) {
            cur.next = new ListNode(l2.val);
            l2 = l2.next;
            cur = cur.next;
        }
        return head.next;
    }
}
