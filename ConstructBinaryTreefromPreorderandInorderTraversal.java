/*
 Author:     Andy, nkuwjg@gmail.com
 Date:       Jan 16, 2015
 Problem:    Construct Binary Tree from Preorder and Inorder Traversal
 Difficulty: Medium
 Source:     https://oj.leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 Notes:
 Given preorder and inorder traversal of a tree, construct the binary tree.
 Note:
 You may assume that duplicates do not exist in the tree.

 Solution: Recursion.
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder.length == 0 || preorder.length == 0 || inorder.length != preorder.length) return null;
        return buildTreeRe(preorder, 0, inorder, 0, preorder.length);
    }
    public TreeNode buildTreeRe(int[] preorder, int s1, int[] inorder, int s2, int size) {
        if (size <= 0 ) return null;
        TreeNode node = new TreeNode(preorder[s1]);
        if (size == 1) return node;
        int pos = s2;
        while (pos <= (s2 + size - 1)) {
            if (inorder[pos] == preorder[s1]) break;
            ++pos;
        }
        int leftlen = pos - s2;
        node.left = buildTreeRe(preorder, s1 + 1, inorder, s2, leftlen);
        node.right = buildTreeRe(preorder, s1 + leftlen + 1, inorder, pos + 1, size - leftlen - 1);
        return node;
    }
}