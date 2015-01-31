/*
 Author:     Andy, nkuwjg@gmail.com
 Date:       Jan 20, 2015
 Problem:    Surrounded Regions
 Difficulty: Easy
 Source:     http://leetcode.com/onlinejudge#question_130
 Notes:
 Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 A region is captured by flipping all 'O's into 'X's in that surrounded region .
 For example,
 X X X X
 X O O X
 X X O X
 X O X X
 After running your function, the board should be:
 X X X X
 X X X X
 X X X X
 X O X X

 Solution: Traverse from the boarder to the inside and mark all the 'O's that are not surrounded by 'X' as 'V' (visited).
           1. BFS (queue).
 */
public class Solution {
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        int M = board.length, N = board[0].length;
        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                if (i == 0 || j == 0 || i == M - 1 || j == N -1) {
                    bfs(board, i, j);
                }
            }
        }
        for (int i = 0; i < M; ++i)
            for (int j = 0; j < N; ++j)
                board[i][j] = (board[i][j] == 'V') ? 'O' : 'X';
    }
    public void bfs(char[][] board, int row, int col) {
        if (board[row][col] != 'O') return;
        int M = board.length, N = board[0].length;
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(row); q.offer(col);
        while (q.isEmpty() == false) {
            int i = q.poll(); int j = q.poll();
            if (i < 0 || i == M || j < 0 || j == N) continue;
            if (board[i][j] != 'O') continue;// important to recheck!
            board[i][j] = 'V';
            q.offer(i-1); q.offer(j);
            q.offer(i+1); q.offer(j);
            q.offer(i); q.offer(j-1);
            q.offer(i); q.offer(j+1);
        }
    }
}