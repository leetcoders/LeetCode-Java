/*
 Author:     Andy, nkuwjg@gmail.com
 Date:       Jan 16, 2015
 Problem:    Construct Binary Tree from Inorder and Postorder Traversal
 Difficulty: Easy
 Source:     http://leetcode.com/onlinejudge#question_106
 Notes:
 Given inorder and postorder traversal of a tree, construct the binary tree.
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0||postorder.length==0||inorder.length!=postorder.length)
            return null;
        return buildTreeRe(inorder,0,inorder.length-1,postorder,0,postorder.length-1); 
    }
    public TreeNode buildTreeRe(int[] inorder,int s1,int e1, int[] postorder, int s2,int e2){
        if(e2<s2) return null;
        if(s2==e2) return new TreeNode(postorder[e2]);
        int j=-1;
        for(int i=s1;i<=e1;i++){
            if(inorder[i]==postorder[e2]){
                j=i;
                break;
            }
        }
        int left_len = j-s1;
        TreeNode root = new TreeNode(postorder[e2]);
        root.left = buildTreeRe(inorder,s1,j-1,postorder,s2,s2+left_len-1);
        root.right = buildTreeRe(inorder,j+1,e1,postorder,s2+left_len,e2-1);
        return root;
    }
}