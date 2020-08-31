package com.hailintang.demo.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hailin.tang
 * @date 2020/7/12 3:44 下午
 * @function
 */
public class Chinese_51 {
    static List<List<String>> res;

    public static List<List<String>> solveNQueens(int n) {
        if (n < 0) {
            return null;
        }
        res = new LinkedList<>();
        char[][] board = new char[n][n];
        for (char[] chars : board) {
            Arrays.fill(chars, '.');
        }
        backtrack(board, 0);
        return res;
    }

    private static List<String> charToString(char[][] array) {
        List<String> result = new LinkedList<>();
        for (char[] chars : array) {
            result.add(String.valueOf(chars));
        }
        return result;
    }

    private static boolean isValid(char[][] board, int row, int col) {
        int rows = board.length;
        // check is valid in col
        for (char[] chars : board) if (chars[col] == 'Q') return false;
        // check is valide upright
        for (int i = row - 1, j = col + 1; i >= 0 && j < rows; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        // check is valide upleft
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }

    /**
     * 路径：board中小于row的那些行都已经成功放置皇后
     * 可选择列表：第row行的所有列都是放置Q的选择
     * 结束条件：row超过board的最后一行
     *
     * @param board
     * @param row
     */
    public static void backtrack(char[][] board, int row) {
        //结束条件
        if (row == board.length) {
            res.add(charToString(board));
            return;
        }

        int n = board[row].length;
        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col)) {
                continue;
            }

            //做出选择
            board[row][col] = 'Q';

            backtrack(board, row + 1);
            //撤销选择
            board[row][col] = '.';
        }
    }

    public static void main(String[] args) {
        List<List<String>> listList = solveNQueens(4);
        System.out.println(listList);
    }
}
