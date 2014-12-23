/*
 Author:     King, higuige@gmail.com
 Date:       Oct 07, 2014
 Problem:    Trapping Rain Water
 Difficulty: Easy
 Source:     https://oj.leetcode.com/problems/trapping-rain-water/
 Notes:
 Given n non-negative integers representing an elevation map where the width of 
 each bar is 1, compute how much water it is able to trap after raining.
 For example, 
 Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

 Solution: 1. Find left bound and right bound for each element. O(n).
           2. more space efficiency. Time: O(n), Space: O(1);
*/
public class Solution {
    public int trap_1(int[] A) {
        int n = A.length;
        if (n == 0) return 0;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        maxLeft[0] = A[0];
        maxRight[n - 1] = A[n - 1];
        for (int i = 1; i < n; ++i) {
            maxLeft[i] = Math.max(maxLeft[i - 1], A[i]);
            maxRight[n - 1 - i] = Math.max(maxRight[n - i], A[n - 1 - i]);
        }
        
        int res = 0;
        for (int i = 1; i < n; ++i) {
            res += Math.min(maxLeft[i], maxRight[i]) - A[i];
        }
        return res;
    }
    public int trap(int[] A) {
        int n = A.length, res = 0;
        if (n <= 2) return 0;
        int maxLeft = A[0];
        int maxRight = A[n - 1];
        int left = 0, right = n - 1;
        while (left <= right) {
            if (maxLeft <= maxRight) {
                res += Math.max(0, maxLeft - A[left]);
                maxLeft = Math.max(maxLeft, A[left]);
                ++left;
            } else {
                res += Math.max(0, maxRight - A[right]);
                maxRight = Math.max(maxRight, A[right]);
                --right;
            }
        }
        return res;
    }
}