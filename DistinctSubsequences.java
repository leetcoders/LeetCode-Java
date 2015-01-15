/*
 Author:     Andy, nkuwjg@gmail.com
 Date:       Oct 07, 2014
 Problem:    Distinct Subsequences
 Difficulty: Easy
 Source:     https://oj.leetcode.com/problems/distinct-subsequences/
 Notes:
 Given a string S and a string T, count the number of distinct subsequences of T in S.
 A subsequence of a string is a new string which is formed from the original string by deleting
 some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

 Here is an example:
 S = "rabbbit", T = "rabbit"
 Return 3.

 Solution: dp.
 */

public class Solution {
    public int numDistinct(String S, String T) {
        int M = S.length();
        int N = T.length();
        int[] dp = new int[N+1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for (int i = 1; i <= M; ++i) {
            for (int j = N; j >=1; --j) {
                dp[j] = dp[j] + (S.charAt(i-1) == T.charAt(j-1) ? dp[j-1] : 0);
            }
        }
        return dp[N];
    }
}