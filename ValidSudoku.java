/*
 Author:     King, wangjingui@outlook.com
 Date:       Dec 20, 2014
 Problem:    Valid Sudoku
 Difficulty: Easy
 Source:     https://oj.leetcode.com/problems/valid-sudoku/
 Notes:
 Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules (http://sudoku.com.au/TheRules.aspx).
 The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

 Solution: 1. Traverse the Sudoku only once.
           2. Bit manipulation. Use only one bit to represent a number. Space: sizeof(int) * (1+9+9).
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] used = new boolean[9];
        
        for(int i=0;i<9;i++){
            Arrays.fill(used,false);
            for(int j = 0; j<9;j++){
                if(check(board[i][j],used)==false) return false;
            }
            Arrays.fill(used,false);
            for(int j = 0; j<9;j++){
                if(check(board[j][i],used)==false) return false;
            }
        }
        
        for(int r = 0; r<3;r++){
            for(int c = 0; c<3;c++){
            Arrays.fill(used,false);
                for(int i = r*3;i<r*3+3;i++){
                    for(int j = c*3;j<c*3+3;j++){
                        if(check(board[i][j],used)==false) return false;
                    }
                }
            }
        }
        return true;
    }
    boolean check(char ch, boolean[] used){
        if(ch=='.') return true;
        if(used[ch-'1']) return false;
        used[ch-'1']=true;
        return true;
    }
}