/*
 Author:     King, wangjingui@outlook.com
 Date:       Oct 9, 2014
 Problem:    Unique Paths
 Difficulty: Easy
 Source:     https://oj.leetcode.com/problems/unique-paths/
 Notes:
 A robot is located at the top-left corner of a m x n grid.
 The robot can only move either down or right at any point in time. The robot is trying to reach 
 the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 How many possible unique paths are there?

 Solution: 
 1. Use formula C(x,t) = t!/(x!*(t-x)!) (x should be large for calculation).
 2. Dynamic programming. UP(i,j) = UP(i-1,j) + UP(i,j-1).
 */
public class Solution {
    public int uniquePaths_1(int m, int n) {
        if (m == 1  || n == 1) return 1;
        int t = (m-1)+(n-1);
        int x = (m > n) ? (m-1) : (n-1);
        long res = 1;
        for (int i = t; i > x; i--) res *= i;
        for (int i = t-x; i > 1; i--) res /= i;
        return (int)res;
    }
    public int uniquePaths_2(int m, int n) {
        if (m == 1  || n == 1) return 1;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++)
            dp[i][0] = 1;
        for (int j = 0; j < n; j++)
            dp[0][j] = 1;
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
        return dp[m-1][n-1];
    }
    public int uniquePaths(int m, int n) {
        if (m == 1  || n == 1) return 1;
        int[] dp = new int[n];
        for (int j = 0; j < n; j++)
            dp[j] = 1;
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                dp[j] = dp[j] + dp[j-1];
        return dp[n-1];
    }
}