package com.yuda.train;

public class Solution206 {
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode result = null;
        while (current != null) {
            // 暂存next
            ListNode next = current.next;

            current.setNext(result);
            result = current;

            // next 为下一个循环节点
            current = next;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}