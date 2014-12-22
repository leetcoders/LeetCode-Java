/*
 Author:     King, wangjingui@outlook.com
 Date:       Dec 20, 2014
 Problem:    Search for a Range
 Difficulty: Medium
 Source:     https://oj.leetcode.com/problems/search-for-a-range/
 Notes:
 Given a sorted array of integers, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].

 Solution: It takes O(lgN) to find both the lower-bound and upper-bound.
 */
public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] res = new int[]{-1,-1};
        int lower = getLowerBound(A, target);
        int upper = getUpperBound(A, target);
        if (lower <= upper) {
            res[0] = lower;
            res[1] = upper;
        }
        return res;
    }
    public int getLowerBound(int[] A, int target) {
        int l = 0, r = A.length - 1;
        while (l <= r) {
            int mid = (l+r) / 2;
            if (A[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return l;
    }
    public int getUpperBound(int[] A, int target) {
        int l = 0, r = A.length - 1;
        while (l <= r) {
            int mid = (l+r) / 2;
            if (A[mid] <= target) l = mid + 1;
            else r = mid - 1;
        }
        return r;
    }
}
