/*
 Author:     King, nkuwjg@gmail.com
 Date:       Aug 23, 2013
 Problem:    N-Queens II
 Difficulty: Medium
 Source:     https://oj.leetcode.com/problems/n-queens-ii/
 Notes:
 The n-queens puzzle is the problem of placing n queens on an n*n chessboard such that no two queens attack each other.
 Given an integer n, return all distinct solutions to the n-queens puzzle.
 Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 For example,
 There exist two distinct solutions to the 4-queens puzzle:
 [
 [".Q..",  // Solution 1
 "...Q",
 "Q...",
 "..Q."],

 ["..Q.",  // Solution 2
 "Q...",
 "...Q",
 ".Q.."]
 ]

 Solution: 1. Recursion.
           2. Recursion + bit version. (fast)
              The idea is from http://www.matrix67.com/blog/archives/266 (in chinese).
           3. Iteration.  
*/
public class Solution {
    public int totalNQueens(int n) {
        return totalNQueens_3(n);
    }
    public int totalNQueens_1(int n) {
        int[] board = new int[n];
        Arrays.fill(board,-1);
        int[] res = new int[1];
        totalNQueensRe(n, 0, board, res);
        return res[0];
    }
    public void totalNQueensRe(int n, int row, int[] board, int[] res) {
        if (n == row) {
            res[0]++;
            return;
        }
        for (int i = 0; i < n; ++i) {
            if (isValid(board, row, i)) {
                board[row] = i;
                totalNQueensRe(n, row + 1, board, res);
                board[row] = -1;
            }
        }
    }
    public boolean isValid(int[] board, int row, int col) {
        for (int i = 0; i < row; ++i) {
            if (board[i] == col || row - i == Math.abs(col - board[i]))
                return false;
        }
        return true;
    }
    public int totalNQueens_2(int n) {
        int[] res = new int[1];
        totalNQueensRe2(n, 0, 0, 0, res);
        return res[0];
    }
    public void totalNQueensRe2(int n, int row, int ld, int rd, int[] res) {
        if (row == (1<<n) -1 ) {
            res[0]++;
            return;
        }
        int avail = ~(row | ld | rd);
        for (int i = n - 1; i >= 0; --i) {
            int pos = 1<<i;
            if ((int)(avail&pos) != 0) {
                totalNQueensRe2(n, row | pos, (ld|pos) << 1, (rd|pos) >>1, res);
            }
        }
    }
    public int totalNQueens_3(int n) {
        int[] a = new int[n];
        Arrays.fill(a,-1);
        int res = 0;
        int row = 0;
        while (row >= 0) {
            if (row == n) {
                res++; row--;
            }
            int i = a[row] == -1 ? 0 : a[row] + 1;
            for ( ; i < n; ++i) {
                if (isValid(a, row, i)) {
                    a[row] = i;
                    row++;
                    break;
                }
            }
            if (i == n) {
                a[row] = -1;
                row--;
            }
        }
        return res;
    }
}