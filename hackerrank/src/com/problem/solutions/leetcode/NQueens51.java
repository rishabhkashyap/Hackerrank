package com.problem.solutions.leetcode;
//Problem: https://leetcode.com/problems/n-queens/
import java.util.ArrayList;
import java.util.List;

public class NQueens51 {
	public static void main(String[] args) {
		int n = 4;
		List<List<String>> matrix = solveNQueens(n);
		System.out.println(matrix);
	}

	public static List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<>();
		char[][] board = new char[n][n];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = '.';
			}
		}
		placeQueens(result, board, n, 0);
		return result;
	}

	public static boolean placeQueens(List<List<String>> result, char[][] board, int n, int i) {
		if (n == 0) {
			updateResult(result, board);
			return false;
		}
		if (i >= board.length) {
			return false;
		}
		for (int j = 0; j < board.length; ++j) {
			if (canPlace(board, i, j)) {
				board[i][j] = 'Q';
				if (placeQueens(result, board, n - 1, i + 1)) {
					return true;
				}
				else {
					board[i][j] = '.';
				}
			}

		}
		return false;
	}

	public static boolean canPlace(char[][] board, int row, int col) {
		//check columns above
		for (int i = 0; i <= row; i++) {
			if (board[i][col] == 'Q') {
				return false;
			}
		}

		int i = row;
		int j = col;
		//Upper left diagonal
		while (i >= 0 && j >= 0) {
			if (board[i][j] == 'Q') {
				return false;
			}
			--i;
			--j;
		}
		//Upper right diagonal
		i = row;
		j = col;
		while (i >= 0 && j < board.length) {
			if (board[i][j] == 'Q') {
				return false;
			}
			--i;
			++j;
		}
		return true;
	}

	public static void updateResult(List<List<String>> result, char[][] board) {
		List<String> strList = new ArrayList<>();
		for (int i = 0; i < board.length; i++) {
			strList.add(new String(board[i]));
		}
		result.add(strList);
	}

}
