package Facebook;

import java.util.Arrays;

public class SudokuSolver {

	public static void main(String args[]) {
		SudokuSolver s = new SudokuSolver();
		char board[][] = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		s.solveSudoku(board);

		for (char[] b : board) {
			System.out.println(Arrays.toString(b));
		}
	}

	public void solveSudoku(char[][] board) {
		if (board == null || board.length == 0) {
			return;
		}
		solve(board);
	}

	private boolean solve(char[][] board) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '.') {
					for (char c = '1'; c <= '9'; c++) {
						if (valid(board, i, j, c)) {
							board[i][j] = c;
							if (solve(board)) {
								return true;
							} else {
								board[i][j] = '.';
							}
						}
					}
					return false;
				}
			}
		}
		return true;

	}

	private boolean valid(char[][] board, int row, int col, char c) {
		for (int i = 0; i < 9; i++) {
			if (board[row][i] != '.' && board[row][i] == c) {
				return false;
			}
			if (board[i][col] != '.' && board[i][col] == c) {
				return false;
			}
			if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.'
					&& board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
				return false;
			}
		}
		return true;
	}

}
