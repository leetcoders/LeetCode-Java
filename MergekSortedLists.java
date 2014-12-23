/*
 Author:     King, wangjingui@outlook.com
 Date:       Dec 17, 2014
 Problem:    Merge k Sorted Lists
 Difficulty: easy
 Source:     https://oj.leetcode.com/problems/merge-k-sorted-lists/
 Notes:
 Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 
 Solution: Find the smallest list-head first using minimum-heap(lgk).
           complexity: O(N*KlgK)
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
    public ListNode mergeKLists_1(List<ListNode> lists) {
        Comparator<ListNode> comp =  new Comparator<ListNode>(){  
            public int compare(ListNode a,  ListNode b) {  
                if(b.val > a.val) {  
                    return -1;  
                }else if(b.val < a.val){  
                    return 1;  
                } else {  
                    return 0;  
                }  
            }  
        };

        Queue<ListNode> q =  new PriorityQueue<ListNode>(10,comp);
        for (int i = 0; i < lists.size(); ++i)
            if (lists.get(i) != null)
                q.add(lists.get(i));
        
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!q.isEmpty()) {
            ListNode node = q.poll();
            cur = cur.next = node;
            if (node.next != null)
                q.add(node.next);
        }
        return dummy.next;
    }
    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) cur.next = l1;
        if (l2 != null) cur.next = l2;
        return head.next;
    }
    public ListNode mergeKLists(List<ListNode> lists) {
        if(lists.size()==0) return null;
        int sz = lists.size(), end = sz - 1;
        while (end > 0) {
            int begin = 0;
            while (begin < end) {
                ListNode node = mergeTwoLists(lists.get(begin), lists.get(end));
                lists.set(begin, node);
                ++begin; --end;
            }
        }
        return lists.get(0);
    }
}