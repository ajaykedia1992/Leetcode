package Facebook;

import java.util.Arrays;

public class ZeroMatrix {

	public static void main(String args[]) {

		boolean[][] matrix = { { true, false, false }, { false, false, false }, { false, false, true } };

		zeroMatrix(matrix);

		for (boolean[] b : matrix) {
			System.out.println(Arrays.toString(b));
		}
	}

	private static void zeroMatrix(boolean[][] matrix) {

		if (matrix.length == 0 || matrix[0].length == 0) {
			return;
		}

		boolean rowZero = false, colZero = false;

		for (boolean b : matrix[0]) {
			rowZero |= b;
		}

		for (boolean[] b : matrix) {
			colZero |= b[0];
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j]) {
					matrix[0][j] = true;
					matrix[i][0] = true;
				}
			}
		}

		for (int i = 1; i < matrix.length; i++) {
			if (matrix[i][0]) {
				for (int j = 1; j < matrix[i].length; j++) {
					matrix[i][j] = true;
				}
			}
		}

		for (int j = 1; j < matrix[0].length; j++) {
			if (matrix[0][j]) {
				for (int i = 1; i < matrix.length; i++) {
					matrix[i][j] = true;
				}
			}
		}

		if (rowZero) {
			for (int i = 0; i < matrix[0].length; i++) {
				matrix[0][i] = true;
			}
		}

		if (colZero) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[j][0] = true;
			}
		}

	}
}
