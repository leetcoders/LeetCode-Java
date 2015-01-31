/*
 Author:     Andy, nkuwjg@gmail.com
 Date:       Jan 26, 2015
 Problem:    Word Break
 Difficulty: Easy
 Source:     http://oj.leetcode.com/problems/word-break/
 Notes:
 Given a string s and a dictionary of words dict, determine if s can be segmented into 
 a space-separated sequence of one or more dictionary words.
 For example, given
 s = "leetcode",
 dict = ["leet", "code"].
 Return true because "leetcode" can be segmented as "leet code".

 Solution: dp.
*/

public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[n] = true;
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i; j < n; ++j) {
                if (dict.contains(s.substring(i,j+1)) && dp[j+1]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}