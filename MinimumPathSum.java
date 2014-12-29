/*
 Author:     King, wangjingui@outlook.com
 Date:       Dec 26, 2014
 Problem:    Minimum Path Sum
 Difficulty: Easy
 Source:     https://oj.leetcode.com/problems/minimum-path-sum/
 Notes:
 Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right 
 which minimizes the sum of all numbers along its path.
 Note: You can only move either down or right at any point in time.

 Solution: Dynamic Programming. Space O(N).
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) return Integer.MIN_VALUE;
        int M = grid.length, N = grid[0].length;
        int[] dp = new int[N];
        dp[0] = grid[0][0];
        for (int i = 1; i < N; ++i)
            dp[i] = grid[0][i] + dp[i-1];
        
        for (int i = 1; i < M; ++i)
        {
            dp[0] += grid[i][0];
            for (int j = 1; j < N; ++j)
                dp[j] = Math.min(dp[j-1], dp[j]) + grid[i][j];
        }
        
        return dp[N-1];  
    }
}