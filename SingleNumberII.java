/*
 Author:     King, wangjingui@outlook.com
 Date:       Jan 3, 2015
 Problem:    Single Number II
 Difficulty: Easy
 Source:     http://oj.leetcode.com/problems/single-number-ii/
 Notes:
 Given an array of integers, every element appears three times except for one. 
 Find that single one.
 Your algorithm should have a linear runtime complexity. Could you implement it 
 without using extra memory?

 Solution: 1. Count the number of each bit.
        2. We can improve this based on the previous solution using three bitmask variables.
        3. An excellent answer by @ranmocy in LeetCode Discuss:
        https://oj.leetcode.com/discuss/857/constant-space-solution?show=2542#a2542
*/
public class Solution {
    public int singleNumber_1(int[] A) {
        int res = 0;
        for (int i = 0; i < 32; ++i) {
            int one = 0;
            for (int num : A) {
                if (((num >> i) & 1) == 1) ++one;
            }
            res = res | ((one % 3)<<i);
        }
        return res;
    }
    public int singleNumber_2(int[] A) {
        int one = 0, twice = 0;
        for (int num : A) {
            twice = twice | (one & num);
            one = one ^ num;
            int three = one & twice;
            one = one ^ three;
            twice = twice ^ three;
        }
        return one;
    }
    public int singleNumber(int[] A) {
        int k = 1, n = 3;
        int[] x = new int[n];
        x[0] = ~0;
        for (int num : A) {
            int t = x[n-1];
            for (int i = n - 1; i >= 1; --i) {
                x[i] = (x[i-1] & num) | (x[i] & ~num);
            }
            x[0] = (t & num) | (x[0] & ~num);
        }
        return x[k];
    }
}