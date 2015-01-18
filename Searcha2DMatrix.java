/*
 Author:     Andy, nkuwjg@gmail.com
 Date:       Jan 16, 2015
 Problem:    Search a 2D Matrix
 Difficulty: Easy
 Source:     https://oj.leetcode.com/problems/search-a-2d-matrix/
 Notes:
 Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 For example,

 Consider the following matrix:

 [
    [1,   3,  5,  7],
    [10, 11, 16, 20],
    [23, 30, 34, 50]
 ]
 Given target = 3, return true.

 Solution: Binary-search.
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int N = matrix.length,M = matrix[0].length;
        int left = 0, right = M * N - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / M, col = mid % M;
            if (matrix[row][col] == target) return true;
            if (matrix[row][col] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}