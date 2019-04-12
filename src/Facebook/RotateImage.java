package Facebook;

import java.util.Arrays;

public class RotateImage {

	public static void main(String args[]) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		RotateImage r = new RotateImage();
		r.rotateImage(matrix);
		for (int[] a : matrix) {
			System.out.println(Arrays.toString(a));
		}
	}

	private void rotateImage(int[][] matrix) {

		if (matrix.length == 0 || matrix[0].length == 0) {
			return;
		}

		for (int i = 0; i <= matrix.length / 2; i++) {
			for (int j = i; j < matrix[i].length - 1 - i; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[matrix.length - 1 - j][i];
				matrix[matrix.length - 1 - j][i] = matrix[matrix.length - 1 - i][matrix.length - 1 - j];
				matrix[matrix.length - 1 - i][matrix.length - 1 - j] = matrix[matrix.length - 1 - j][i];
				matrix[matrix.length - 1 - j][i] = temp;
			}
		}

	}
}
