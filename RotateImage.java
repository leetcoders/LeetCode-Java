/*
 Author:     King, wangjingui@outlook.com
 Date:       Dec 25, 2014
 Problem:    Rotate Image
 Difficulty: Easy
 Source:     https://oj.leetcode.com/problems/rotate-image/
 Notes:
 You are given an n x n 2D matrix representing an image.
 Rotate the image by 90 degrees (clockwise).
 Follow up:
 Could you do this in-place?

 Solution: 1. 123   ->  147   ->   741    (preferable)
              456       258        852
              789       369        963
           2. Rotate one-fourth of the image clockwise.
 */
public class Solution {
    public void rotate_1(int[][] matrix) {
        int n = matrix.length;
        if (n <= 1) return;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                int tmp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=tmp;
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int tmp = matrix[i][j];
                matrix[i][j]=matrix[i][n-1-j];
                matrix[i][n-1-j] = tmp;
            }
        }
    }
    public void rotate_2(int[][] matrix) {
        int n = matrix.length;
        if (n <= 1) return;
        int level = 0;
        while (level < n / 2) {
            for (int i = level; i < n - 1 - level; ++i) {
                int tmp = matrix[i][level];
                matrix[i][level] = matrix[n - 1 - level][i];
                matrix[n - 1 - level][i] = matrix[n - 1 - i][n - 1 - level];
                matrix[n - 1 - i][n - 1 - level] = matrix[level][n - 1 - i];
                matrix[level][n - 1 - i] = tmp;
            }
            ++level;
        }
    }
}