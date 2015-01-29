/*
 Author:     Andy, nkuwjg@gmail.com
 Date:       Jan 29, 2015
 Problem:    Convert Sorted Array to Binary Search Tree
 Difficulty: Medium
 Source:     https://oj.leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 Notes:
 Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

 Solution: Recursion. 1. preorder
                      2. inorder
 */

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST_1(int[] num) {
        return sortedArrayToBSTRe(num, 0, num.length - 1);
    }
    public TreeNode sortedArrayToBSTRe(int[] num, int left, int right) {
        if (left > right) return null;
        if (left == right) return new TreeNode(num[left]);
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = sortedArrayToBSTRe(num, left, mid - 1);
        node.right = sortedArrayToBSTRe(num, mid + 1, right);
        return node;
    }
    public TreeNode sortedArrayToBST(int[] num) {
        int[] curidx = new int[1];
        curidx[0] = 0;
        return sortedArrayToBSTRe1(num, num.length, curidx);
    }
    public TreeNode sortedArrayToBSTRe1(int[] num, int len, int[] curidx) {
        if (len == 0) return null;
        if (len == 1) return new TreeNode(num[curidx[0]++]);
        int mid = len / 2;
        TreeNode left = sortedArrayToBSTRe1(num, mid, curidx);
        TreeNode node = new TreeNode(num[curidx[0]++]);
        node.left = left;
        node.right = sortedArrayToBSTRe1(num, len - 1 - mid, curidx);
        return node;
    }
}