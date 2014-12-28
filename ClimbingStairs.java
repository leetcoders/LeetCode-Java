/*
 Author:     King,wangjingui@outlook.com
 Date:       Dec 25, 2014
 Problem:    Climbing Stairs
 Difficulty: Easy
 Source:     https://oj.leetcode.com/problems/climbing-stairs/
 Notes:
 You are climbing a stair case. It takes n steps to reach to the top.
 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 Solution: Clime one step from last stair or clime 2 steps from the last last stair.
 */
public class Solution {
    public int climbStairs(int n) {
        int[] f = new int[n+1];
        f[0] = 1; f[1] = 1;
        for (int i = 2; i <= n; ++i)
            f[i] = f[i-1] + f[i-2];
        return f[n];
    }
}