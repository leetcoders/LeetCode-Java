/*
 Author:     King, wangjingui@outlook.com
 Date:       Dec 24, 2013
 Problem:    Sort Colors
 Difficulty: Medium
 Source:     http://lintcode.com/zh-cn/problem/sort-colors-ii/
 Notes:
 Given an array of n objects with k different colors (numbered from 1 to k), sort them so that objects of the same color are adjacent, with the colors in the order 1, 2, ... k.

 Note
 You are not suppose to use the library's sort function for this problem.

 Example
 GIven colors=[3, 2, 2, 1, 4], k=4, your code should sort colors in-place to [1, 2, 2, 3, 4]. 

 Challenge
 A rather straight forward solution is a two-pass algorithm using counting sort. That will cost O(k) extra memory.

 Can you do it without using extra memory?

 Solution: Use the first k buckets to store the count. (count sort, two pass).
 */
class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] A, int k) {
        // write your code here
        int n = A.length;
        if (n <= 1) return;
        for (int i = 0; i < n; ++i) {
            if(A[i] > 0) {
                int c = A[i];
                A[i] = 0;
                while(true) {
                    if (A[c-1] <= 0) {
                        --A[c-1];
                        break;
                    } else {
                        int col = A[c-1];
                        A[c-1] = -1;
                        c = col;
                    }
                }
            }
        }
        int idx = n;
        for (int i = k; i > 0; --i) {
            for (int j = 0; j > A[i-1]; --j) A[--idx] = i;
        }
    }
}
