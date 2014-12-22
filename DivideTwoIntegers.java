/*
 Author:     King, higuige@gmail.com
 Date:       Nov 18, 2014
 Problem:    Divide Two Integers
 Difficulty: Medium
 Source:     https://oj.leetcode.com/problems/divide-two-integers/
 Notes:
 Divide two integers without using multiplication, division and mod operator.

 Solution: Use << operator.
*/
public class Solution {
    public int divide(int dividend, int divisor) {
        boolean flag = dividend < 0 ^ divisor < 0;
        long Dividend = Math.abs((long)dividend);
        long Divisor = Math.abs((long)divisor);
        long res = 0;
        while (Dividend >= Divisor) {
            long c = Divisor;
            for (int i = 0; (c << i) <= Dividend; ++i) {
                Dividend -= (c << i);
                res += (1 << i);
            }
        }
        if (flag == true) res = -res;
        if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return (int)res;
    }
}