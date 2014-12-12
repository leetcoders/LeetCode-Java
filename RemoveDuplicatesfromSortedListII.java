/*
 Author:     King, wangjingui@outlook.com
 Date:       Dec 12, 2014
 Problem:    Remove Duplicates from Sorted List II
 Difficulty: Medium
 Source:     https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 Notes:
 Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 For example,
 Given 1->2->3->3->4->4->5, return 1->2->5.
 Given 1->1->1->2->3, return 2->3.

 Solution: 1. iterative 2. recursive
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
    public ListNode deleteDuplicates_1(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val)
                    head = head.next;
            } else {
                cur.next = head;
                cur = cur.next;
            }
            head = head.next;
        }
        cur.next = null;
        return dummy.next;
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        if (head.next == null || head.val != head.next.val){
            head.next = deleteDuplicates(head.next);
            return head;
        }
        while (head.next != null && head.val == head.next.val)
            head = head.next;
        return deleteDuplicates(head.next);
    }
}