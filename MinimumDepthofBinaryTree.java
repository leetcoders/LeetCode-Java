/*
 Author:     King, wangjingui@outlook.com
 Date:       Dec 25, 2014
 Problem:    Minimum Depth of Binary Tree
 Difficulty: easy
 Source:     https://oj.leetcode.com/problems/minimum-depth-of-binary-tree/
 Notes:
 Given a binary tree, find its minimum depth.
 The minimum depth is the number of nodes along the shortest path from the root node 
 down to the nearest leaf node.
 
 Solution: 1. Recursion. Pay attention to cases when the non-leaf node has only one child.
           PS. 2. Iteration + Queue. 
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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}