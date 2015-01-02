/*
 Author:     King, wangjingui@outlook.com
 Date:       Jan 2, 2015
 Problem:    Reverse Linked List II
 Difficulty: Easy
 Source:     https://oj.leetcode.com/problems/reverse-linked-list-ii/
 Notes:
 Reverse a linked list from position m to n. Do it in-place and in one-pass.
 For example:
 Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 return 1->4->3->2->5->NULL.
 Note:
 Given m, n satisfy the following condition:
 1 <= m <= n <= length of list.

 Solution: in-place & one-pass.
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = dummy;
        for (int i = 0; i < m - 1; ++i) first = first.next;
        ListNode cur = first.next;
        for (int i = 0; i < n - m; ++i) {
            ListNode move = cur.next;
            cur.next = move.next;
            move.next = first.next;
            first.next = move;
        }
        return dummy.next;
    }
}