/*
 Author:     King, wangjingui@outlook.com
 Date:       Dec 20, 2014
 Problem:    Swap Nodes in Pairs
 Difficulty: Medium
 Source:     https://oj.leetcode.com/problems/swap-nodes-in-pairs/
 Notes:
 Given a linked list, swap every two adjacent nodes and return its head.
 For example,
 Given 1->2->3->4, you should return the list as 2->1->4->3.
 Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

 Solution: 1. Iterative solution with constant space.
           2. Recursive solution with O(n) space (for practice).
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode swapPairs_1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode node = cur.next.next;
            cur.next.next = node.next;
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
        return dummy.next;
    }
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode first = head, second = head.next;
        first.next = second.next;
        second.next = first;
        first.next = swapPairs(first.next);
        return second;
    }
}