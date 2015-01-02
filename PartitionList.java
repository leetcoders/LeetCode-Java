/*
 Author:     King, higuige@gmail.com
 Date:       Oct 7, 2014
 Problem:    Partition List
 Difficulty: Easy
 Source:     https://oj.leetcode.com/problems/partition-list/
 Notes:
 Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 You should preserve the original relative order of the nodes in each of the two partitions.
 For example,
 Given 1->4->3->2->5->2 and x = 3,
 return 1->2->2->4->3->5.

 Solution: ...
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
    public ListNode partition_1(ListNode head, int x) {
        ListNode leftdummy = new ListNode(-1);
        ListNode rightdummy = new ListNode(-1);
        ListNode lhead = leftdummy;
        ListNode rhead = rightdummy;
        
        for(ListNode cur = head; cur != null; cur=cur.next){
            if(cur.val < x){
                lhead.next = cur;
                lhead = lhead.next;
            }else{
                rhead.next = cur;
                rhead = rhead.next;
            }
        }
        lhead.next = rightdummy.next;
        rhead.next = null;
        return leftdummy.next;
    }
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode ins = dummy;
        while (cur.next != null && cur.next.val < x) {
            cur = cur.next;
            ins = ins.next;
        }
        while (cur.next != null) {
            if (cur.next.val >= x) {
                cur = cur.next;
            } else {
                ListNode node = cur.next;
                cur.next = cur.next.next;
                node.next = ins.next;
                ins.next = node;
                ins = ins.next;
            }
        }
        return dummy.next;
    }
}