/*
 Author:     Annie Kim, anniekim.pku@gmail.com
 Date:       Dec 12, 2014 [Two pointers ('last' and 'lastlast').]
 Problem:    Remove Duplicates from Sorted Array II
 Difficulty: Medium
 Source:     https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 Notes:
 Follow up for "Remove Duplicates":
 What if duplicates are allowed at most twice?
 For example,
 Given sorted array A = [1,1,1,2,2,3],
 Your function should return length = 5, and A is now [1,1,2,2,3].

 Solution: ...
 */
public class Solution {
    public int removeDuplicates(int[] A) {
        int N = A.length;
        if (N <= 2) return N;
        int idx = 2;
        for (int i = 2; i < N; ++i) {
            if (A[i] != A[idx-2])
                A[idx++] = A[i];
        }
        return idx;
    }
}