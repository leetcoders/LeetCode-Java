/*
 Author:     King, wangjingui@outlook.com
 Date:       Oct 06, 2014
 Problem:    Maximum Product Subarray
 Difficulty: Medium
 Source:     https://oj.leetcode.com/problems/maximum-product-subarray/
 Notes:
 Find the contiguous subarray within an array (containing at least one number) which has the largest product.

 For example, given the array [2,3,-2,4],
 the contiguous subarray [2,3] has the largest product = 6.
*/

public class Solution {
    public int maxProduct(int[] A) {
        if (A.length <= 0) {
            return 0;
        }
        int maxVal = A[0], minVal = A[0], res = A[0];
        for (int i = 1; i < A.length; ++i) {
            int tmpVal = maxVal;
            maxVal = Math.max(Math.max(maxVal * A[i], minVal * A[i]), A[i]);
            minVal = Math.min(Math.min(tmpVal * A[i], minVal * A[i]), A[i]);
            res = Math.max(res, maxVal);
        }
        return res;  
    }
}