/*
 Author:     Andy, nkuwjg@gmail.com
 Date:       Jan 23, 2015
 Problem:    Palindrome Partitioning II
 Difficulty: Hard
 Source:     https://oj.leetcode.com/problems/palindrome-partitioning-ii/
 Notes:
 Given a string s, partition s such that every substring of the partition is a palindrome.
 Return the minimum cuts needed for a palindrome partitioning of s.
 For example, given s = "aab",
 Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.

 Solution: dp.
 */
public class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[n] = -1;
        boolean[][] isP = new boolean[n][n];
        for (int i = n - 1; i >= 0; --i) {
            dp[i] = n - 1 - i;
            for (int j = i; j < n; ++j) {
                if (s.charAt(i) == s.charAt(j) && (j < i + 2 || isP[i+1][j-1])) isP[i][j] = true;
                if (isP[i][j] == true) {
                    dp[i] = Math.min(dp[i], 1 + dp[j+1]);
                }
            }
        }
        return dp[0];
    }
}