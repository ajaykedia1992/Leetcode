import java.util.Arrays;
import java.util.List;

public class TextJustification {

	public static void main(String args[]) {
		String arr[] = { "This", "is", "an", "example", "of", "text", "justification." };
		int maxWidth = 16;
		List<String> result = fullJustify(arr, maxWidth);
		// result.forEach(x -> System.out.println(result));
	}

	private static List<String> fullJustify(String arr[], int maxWidth) {

		int[][] matrix = new int[arr.length][arr.length];

		for (int i = 0; i < matrix.length; i++) {
			matrix[i][i] = (int) Math.pow(maxWidth - (arr[i].length()), 2);
		}

		for (int i = 0; i < matrix.length - 1; i++) {
			int length = arr[i].length() + arr[i + 1].length() + 1;
			matrix[i][i + 1] = length > maxWidth ? Integer.MAX_VALUE : (int) Math.pow(maxWidth - length, 2);
		}

		for (int k = 3; k <= arr.length; k++) {
			for (int j = 0; j < arr.length - k + 1; j++) {
				int end = j + k - 1;
				int length = 0;
				for (int i = j; i <= end; i++) {
					length += arr[i].length() + 1;
				}
				length--;
				matrix[j][end] = length > maxWidth ? Integer.MAX_VALUE : (int) Math.pow(maxWidth - length, 2);

			}

		}

		printMatrix(matrix);

		int[] index = new int[arr.length];
		int[] justify = new int[arr.length];
		Arrays.fill(justify, Integer.MAX_VALUE);

		GetTheString(arr, matrix, index, justify);

		return null;
	}

	private static void GetTheString(String[] arr, int[][] matrix, int[] index, int[] justify) {
		int n = arr.length;
		for (int j = n - 1; j >= 0; j--) {
			int i = n - 1;
			if (matrix[j][i] != Integer.MAX_VALUE && matrix[j][i] < justify[j]) {
				justify[j] = matrix[i][j];
				index[j] = i;
			} else {
				for (int k = i; k > j; k--) {
					index[j] = justify[j] > matrix[j][k - 1] + matrix[k][matrix[0].length - 1] ? index[k - 1] : index[j];
					justify[j] = Math.min(justify[j], matrix[j][k - 1] + matrix[k][matrix[0].length - 1]);
				}
			}
			
			System.out.println("---------------------------------");
			System.out.println(Arrays.toString(justify));
			System.out.println(Arrays.toString(index));
		}
		System.out.println("---------------------------------");
		System.out.println(Arrays.toString(justify));
		System.out.println(Arrays.toString(index));

	}

	private static void printMatrix(int[][] matrix) {

		for (int[] a : matrix) {
			System.out.println(Arrays.toString(a));
		}

	}
}
