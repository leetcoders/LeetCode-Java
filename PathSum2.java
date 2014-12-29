/*
 Author:     King, higuige@gmail.com
 Date:       Oct 7, 2014
 Problem:    Path Sum 2
 Difficulty: easy
 Source:     https://oj.leetcode.com/problems/path-sum-ii/
 Notes:
 Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
 return
 [
   [5,4,11,2],
   [5,8,4,5]
 ]
 
 Solution: DFS. 
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        pathSumRe(root, sum, res, path);
        return res; 
    }
    public void pathSumRe(TreeNode root, int sum, List<List<Integer>> res, ArrayList<Integer> path)
    {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null && root.val == sum){
            ArrayList<Integer> tmp = new ArrayList<Integer>(path);
            res.add(tmp);
        }
        pathSumRe(root.left, sum - root.val, res, path);
        pathSumRe(root.right, sum - root.val, res, path);
        path.remove(path.size()-1);
    }
}

