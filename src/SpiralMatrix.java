import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {

	public static void main(String args[]) {
		 int[][] matrix = { { 1, 2, 3, 4 }, { 12, 13, 14, 5 }, { 11, 16, 15, 6 }, {
		 10, 9, 8, 7 } };

		//int[][] matrix = { { 6, 9, 7 } };
		for (int[] i : matrix) {
			System.out.println(Arrays.toString(i));
		}

		printSpiralMatrix(matrix);
	}

	private static void printSpiralMatrix(int[][] matrix) {

		int rowStart = 0;
		int rowEnd = matrix.length - 1;
		int colStart = 0;
		int colEnd = matrix[0].length - 1;
		List<Integer> result = new ArrayList<Integer>();
		while (rowStart <= rowEnd && colStart <= colEnd) {
			for (int i = colStart; i <= colEnd; i++) {
				result.add(matrix[rowStart][i]);
			}

			for (int i = rowStart + 1; i <= rowEnd; i++) {
				result.add(matrix[i][colEnd]);
			}

			if (rowStart < rowEnd && colStart < colEnd) {

				for (int i = colEnd - 1; i > colStart; i--) {
					result.add(matrix[rowEnd][i]);
				}

				for (int i = rowEnd; i > rowStart; i--) {
					result.add(matrix[i][colStart]);
				}
			}

			rowStart += 1;
			colEnd -= 1;
			rowEnd -= 1;
			colStart += 1;

		}

		System.out.println(result);
	}
}
