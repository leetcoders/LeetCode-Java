/*
 Author:     King, wangjingui@outlook.com
 Date:       Dec 25, 2014
 Problem:    Edit Distance
 Difficulty: Medium
 Source:     https://oj.leetcode.com/problems/edit-distance/
 Notes:
 Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
 You have the following 3 operations permitted on a word:
 a) Insert a character
 b) Delete a character
 c) Replace a character

 Solution: Dynamic Programming.
           1. Time: O(mn) Space: O(mn)
           2. Time: O(mn) Space: O(n);
 */
public class Solution {
    public int minDistance_1(String word1, String word2) {
        if(word1==word2) return 0;
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        
        for(int i=0;i<=len1;i++)
            dp[i][0] = i;
        for(int i=0;i<=len2;i++)
            dp[0][i] = i;
        
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else{
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                }
            }
        }
        return dp[len1][len2];
    }
    public int minDistance(String word1, String word2) {
        if(word1==word2) return 0;
        int len1 = word1.length();
        int len2 = word2.length();
        int[] dp = new int[len2+1];
        
        for(int i=0;i<=len2;i++)
            dp[i] = i;
        
        for(int i=1;i<=len1;i++){
            int upperLeftBak = dp[0];
            dp[0] = i;
            for(int j=1;j<=len2;j++){
                int upperLeft = upperLeftBak;
                upperLeftBak = dp[j];
                if(word1.charAt(i-1)==word2.charAt(j-1)) dp[j] = upperLeft;
                else{
                    dp[j] = Math.min(dp[j],Math.min(dp[j-1],upperLeft))+1;
                }
            }
        }
        return dp[len2];
    }
}