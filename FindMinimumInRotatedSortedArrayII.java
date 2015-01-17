/*
 Author:     Andy, nkuwjg@gmail.com
 Date:       Oct 22, 2014
 Problem:    Find Minimum in Rotated Sorted ArrayII
 Difficulty: Hard
 Source:     https://oj.leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 Notes:
 Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 The array may contain duplicates.
*/

public class Solution {
    public int findMin(int[] num) {
        if (num.length == 0) return 0;
        int left = 0, right = num.length -1;
        while (left < right && num[left] >= num[right]) {
            int mid = left + (right - left) / 2;
            if (num[mid] > num[right]) left = mid + 1;
            else if (num[mid] < num[right]) right = mid;
            else left++;
        }
        return num[left];
    }
}