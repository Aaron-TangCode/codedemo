package com.hailintang.demo.leetcode;

/**
 * @author hailin.tang
 * @date 2020/7/13 4:01 下午
 * @function
 */
public class Chinese_36 {
    public static boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] != '.') {
                    int value = board[row][col] - '1';
                    int boxIndex = row / 3 * 3 + col / 3;
                    if (rows[row][value] || cols[col][value] || boxes[boxIndex][value]) {
                        return false;
                    }

                    rows[row][value] = true;
                    cols[col][value] = true;
                    boxes[boxIndex][value] = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] arr = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        boolean validSudoku = isValidSudoku(arr);
        
    }
}
