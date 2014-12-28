/*
 Author:     King, wangjingui@outlook.com
 Date:       Dec 25, 2014
 Problem:    Pow(x, n)
 Difficulty: easy
 Source:     https://oj.leetcode.com/problems/powx-n/
 Notes:
 Implement pow(x, n).
 
 Solution: recursion.
 */
public class Solution {
    public double pow(double x, int n) {
        if (x < 0) return (n % 2 == 0) ? pow(-x, n) : -pow(-x, n);
        if (x == 0 || x == 1) return x;
        if (n < 0) return 1.0 / pow(x,-n);
        if (n == 0) return 1.0;
        if (n == 1) return x;
        double half = pow(x,n/2);
        if (n % 2 == 0) return half * half;
        else return x * half * half;
    }
}