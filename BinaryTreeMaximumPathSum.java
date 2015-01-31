/*
 Author:     Andy, nkuwjg@gmail.com
 Date:       Jan 28, 2015
 Problem:    Binary Tree Maximum Path Sum
 Difficulty: Easy
 Source:     https://oj.leetcode.com/problems/binary-tree-maximum-path-sum/
 Notes:
 Given a binary tree, find the maximum path sum.
 The path may start and end at any node in the tree.
 For example:
 Given the below binary tree,
   1
  / \
 2   3
 Return 6.

 Solution: Recursion...
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
    public int maxPathSum(TreeNode root) {
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        maxPathSumRe(root, res);
        return res[0];
    }
    int maxPathSumRe(TreeNode root, int[] res) {
        if (root == null) return 0;
        int left = maxPathSumRe(root.left, res);
        int right = maxPathSumRe(root.right, res);
        res[0] = Math.max(res[0], root.val + Math.max(left, 0) + Math.max(right, 0));
        return Math.max(root.val, root.val + Math.max(left, right));
    }
}