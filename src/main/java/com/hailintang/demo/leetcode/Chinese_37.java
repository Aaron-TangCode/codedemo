package com.hailintang.demo.leetcode;

/**
 * @author hailin.tang
 * @date 2020/7/13 5:14 下午
 * @function
 */
public class Chinese_37 {
    public static void solveSudoku(char[][] board) {
        backtrack(board,0,0);
    }

    public static boolean backtrack(char[][] board,int row,int col) {
        int hang = 9;
        int lie = 9;
        if (col == lie) {
            //穷举到最后一列的话，就换到下一行重新开始
            return backtrack(board, row + 1, 0);
        }

        if (row == hang) {
            return true;
        }

        if (board[row][col] != '.') {
            return backtrack(board, row, col + 1);
        }

        for (char ch = '1'; ch <= '9'; ch++) {
            if (!isValid(board, row, col, ch)) {
                continue;
            }
            board[row][col] = ch;
            backtrack(board, row, col + 1);
            board[row][col] = '.';
        }
        return false;
    }
    // 判断 board[i][j] 是否可以填入 n
    public static boolean isValid(char[][] board, int r, int c, char n) {
        for (int i = 0; i < 9; i++) {
            // 判断行是否存在重复
            if (board[r][i] == n) return false;
            // 判断列是否存在重复
            if (board[i][c] == n) return false;
            // 判断 3 x 3 方框是否存在重复
            if (board[(r/3)*3 + i/3][(c/3)*3 + i%3] == n)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] arr = new char[][]
                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        solveSudoku(arr);
    }
}
