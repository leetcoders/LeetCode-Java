/*
 Author:     King, wangjingui@outlook.com
 Date:       Dec 20, 2014
 Problem:    Sudoku Solver
 Difficulty: Medium
 Source:     https://oj.leetcode.com/problems/sudoku-solver/
 Notes:
 Write a program to solve a Sudoku puzzle by filling the empty cells.
 Empty cells are indicated by the character '.'.
 You may assume that there will be only one unique solution.

 Solution: back-tracking..
 */
public class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    boolean solve(char[][] board){
        for(int i = 0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char ch = '1';ch<='9';ch++){
                        board[i][j]=ch;
                        if(isValidSudoKu(board,i,j)&&solve(board)) return true;
                        board[i][j]='.';
                    }
                    return false;
                }
            }
        }
        return true;
    }
    boolean isValidSudoKu(char[][] board, int x, int y){
        for(int i = 0; i<9; i++){
            if(i!=y&&board[x][i]==board[x][y]) return false;
        }
        for(int i=0;i<9;i++){
            if(i!=x&&board[i][y]==board[x][y]) return false;
        }
        for(int i=3*(x/3);i<3*(x/3)+3;i++){
            for(int j=3*(y/3);j<3*(y/3)+3;j++){
                if(i!=x&&j!=y&&board[i][j]==board[x][y]) return false;
            }
        }
        return true;
    }
}
