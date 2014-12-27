/*
 Author:     King, wangjingui@outlook.com
 Date:       Dec 21, 2014
 Problem:    Jump Game
 Difficulty: Easy
 Source:     https://oj.leetcode.com/problems/jump-game/
 Notes:
 Given an array of non-negative integers, you are initially positioned at the first index of the array.
 Each element in the array represents your maximum jump length at that position.
 Determine if you are able to reach the last index.
 For example:
 A = [2,3,1,1,4], return true.
 A = [3,2,1,0,4], return false.

 Solution: Updated solution: try every reachable index. 
           Thank to Wenxin Xing for kindly feedback and pointing out my big mistake:)
 */
public class Solution {
    public boolean canJump(int[] A) {
        int pos = 0, n = A.length;
        for (int i = 0; i < n; ++i) {
            if (pos >= i) {
                pos = Math.max(pos, i + A[i]);
            }
        }
        return pos >= n - 1;
    }
}