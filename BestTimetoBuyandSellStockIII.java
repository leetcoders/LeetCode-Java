/*
 Author:     King, wangjingui@outlook.com
 Date:       Jan 02, 2015
 Problem:    Best Time to Buy and Sell Stock III
 Difficulty: Medium
 Source:     https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 Notes:
 Say you have an array for which the ith element is the price of a given stock on day i.
 Design an algorithm to find the maximum profit. You may complete at most two transactions.
 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

 Solution: dp. max profit =  max { l2r[0...i] + r2l[i+1...N-1] }.
                         0 <= i <= N-1
 */

public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;
        int[] l2r = new int[n];
        int[] r2l = new int[n];
        l2r[0] = 0; r2l[n-1] = 0;
        int minVal = prices[0], maxVal = prices[n-1];
        for (int i = 1; i < n; ++i) {
            l2r[i] = Math.max(l2r[i-1], prices[i] - minVal);
            minVal = Math.min(minVal, prices[i]);
        }
        for (int i = n - 2; i >= 0; --i) {
            r2l[i] = Math.max(r2l[i+1], maxVal - prices[i]);
            maxVal = Math.max(maxVal, prices[i]);
        }
        int res = l2r[n-1];
        for (int i = 0; i < n - 1; ++i) {
            res = Math.max(res, l2r[i] + r2l[i+1]);
        }
        return res;
    }
}