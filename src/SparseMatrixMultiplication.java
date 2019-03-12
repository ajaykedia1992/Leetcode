import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SparseMatrixMultiplication {

	public static void main(String args[]) {
		/*int[][] A = { { 1, 0, 0	}, { -1, 0, 3 } };
		int[][] B = { { 7, 0, 0 }, {0, 0, 0 }, { 0, 0, 1} };*/
		
		int[][] A = {{1,-5}};
		int[][] B = {{12}, {-1}};

		int[][] result = multiply(A, B);
		if (result == null) {
			throw new IllegalArgumentException();
		} else {
			for (int[] r : result) {
				System.out.println(Arrays.toString(r));
			}
		}
	}

	private static int[][] multiply(int[][] a, int[][] b) {

		if (a == null || b == null || a.length == 0 || b.length == 0) {
			return null;
		}

		int m = a.length, n = a[0].length, nb = b[0].length;

		int[][] result = new int[m][nb];

		List[] indexA = new List[m];

		for (int i = 0; i < m; i++) {
			List<Integer> temp = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				if (a[i][j] != 0) {
					temp.add(j);
					temp.add(a[i][j]);
				}
			}
			indexA[i] = temp;
		}

		printList(indexA);

		for (int i = 0; i < m; i++) {
			List<Integer> temp = indexA[i];
			for (int j = 0; j < temp.size() - 1; j += 2) {
				int colA = temp.get(j);
				int valA = temp.get(j + 1);
				for (int k = 0; k < nb; k++) {
					int valB = b[colA][k];
					result[i][k] += valA * valB;
				}
			}
		}

		return result;
	}

	private static void printList(List[] indexA) {

		for (List a : indexA) {
			a.forEach(x -> System.out.print(x + " "));
			System.out.println();
		}
	}
}
