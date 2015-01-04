/*
 Author:     King, wangjingui@outlook.com
 Date:       Jan 3, 2015
 Problem:    Single Number
 Difficulty: Easy
 Source:     http://oj.leetcode.com/problems/single-number/
 Notes:
 Given an array of integers, every element appears twice except for one. 
 Find that single one.
 Your algorithm should have a linear runtime complexity. 
 Could you implement it without using extra memory?

 Solution: XOR.
*/
public class Solution {
    public int singleNumber(int[] A) {
        int res = 0;
        for (int i : A) {
            res = res^i;
        }
        return res;
    }
}