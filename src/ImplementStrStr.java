import java.util.Arrays;

public class ImplementStrStr {

	public static void main(String args[]) {
		String haystack = "hello";
		String needle = "hello";
		System.out.println(strStr(haystack, needle));
	}

	public static int strStr(String haystack, String needle) {
		if (needle.isEmpty()) {
			return 0;
		}

		int[][] matrix = new int[needle.length() + 1][haystack.length() + 1];

		Arrays.fill(matrix[0], 0, matrix[0].length, 0);
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][0] = 0;
		}

		int max = Integer.MIN_VALUE;
		int indexI = -1;
		int indexJ = -1;
		for (int i = 0; i < needle.length(); i++) {
			for (int j = 0; j < haystack.length(); j++) {
				if (needle.charAt(i) == haystack.charAt(j)) {
					matrix[i + 1][j + 1] = matrix[i][j] + 1;
					if (max < matrix[i + 1][j + 1]) {
						max = matrix[i + 1][j + 1];
						indexI = i + 1;
						indexJ = j + 1;
					}
				}
			}
		}
		//print(matrix);
		// System.out.println(max + "," + indexI + "," + indexJ);

		if (max != needle.length()) {
			return -1;
		}

		return findIndex(matrix, indexI, indexJ);
	}

	private static int findIndex(int[][] matrix, int i, int j) {

		while (matrix[i][j] != 0) {
			i--;
			j--;
		}
		return j;
	}

	public static void print(int[][] matrix) {
		for (int[] m : matrix) {
			System.out.println(Arrays.toString(m));
		}
	}
}
