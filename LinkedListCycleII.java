/*
 Author:     King, wangjingui@outlook.com
 Date:       Jan 02, 2015
 Problem:    Linked List Cycle II
 Difficulty: Easy
 Source:     http://oj.leetcode.com/problems/linked-list-cycle-ii/
 Notes:
 Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 Follow up:
 Can you solve it without using extra space?

 Solution: ...
*/

/**
* Definition for singly-linked list.
* class ListNode {
*     int val;
*     ListNode next;
*     ListNode(int x) {
*         val = x;
*         next = null;
*     }
* }
*/
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (fast == null || fast.next == null) return null;
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}