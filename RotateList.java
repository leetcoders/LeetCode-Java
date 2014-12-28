/*
 Author:     King, wangjingui@outlook.com
 Date:       Dec 25, 2014
 Problem:    Rotate List
 Difficulty: Easy
 Source:     https://oj.leetcode.com/problems/rotate-list/
 Notes:
 Given a list, rotate the list to the right by k places, where k is non-negative.

 For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.

 Solution: Notice that k can be larger than the list size (k % list_size).
           This solution traverses the list twice at most.
*/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        int n = 1;
        ListNode tail = head, cur = head;
        while (tail.next != null) {
            tail = tail.next;
            ++n;
        }
        k = k % n;
        if (k == 0) return head;
        for (int i = 0; i < n - k - 1; ++i) 
            cur = cur.next;
        ListNode newHead = cur.next;
        tail.next = head;
        cur.next = null;
        return newHead;
    }
}