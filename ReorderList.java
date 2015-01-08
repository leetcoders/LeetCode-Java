/*
 Author:     King, wangjingui@outlook.com
 Date:       Jan 8, 2015
 Problem:    Reorder List
 Difficulty: Easy
 Source:     http://oj.leetcode.com/problems/reorder-list/
 Notes:
 Given a singly linked list L: L0->L1->...->Ln-1->Ln,
 reorder it to: L0->Ln->L1->Ln-1->L2->Ln-2->...
 You must do this in-place without altering the nodes' values.
 For example,
 Given {1,2,3,4}, reorder it to {1,4,2,3}.

 Solution: Reverse the back half first, then reorder.
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
    public void reorderList_1(ListNode head) {
        ListNode slow = head, fast = head;
        if (head == null || head.next == null) return;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        slow.next = null;
        slow = head;
        ListNode pre = null;
        while (fast != null) {
            ListNode next = fast.next;
            fast.next = pre;
            pre = fast;
            fast = next;
        }
        fast = pre;
        while (fast != null) {
            ListNode fastnext = fast.next;
            fast.next = slow.next;
            slow.next = fast;
            fast = fastnext;
            slow = slow.next.next;
        }
    }
    public void reorderList_2(ListNode head) {
        ListNode slow = head, fast = head;
        if (head == null || head.next == null) return;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        while (fast.next != null) {
            ListNode move = fast.next;
            fast.next = move.next;
            move.next = slow.next;
            slow.next = move;
        }
        fast = slow.next;
        slow.next = null;
        slow = head;
        while (fast != null) {
            ListNode fastnext = fast.next;
            fast.next = slow.next;
            slow.next = fast;
            fast = fastnext;
            slow = slow.next.next;
        }
    }
}