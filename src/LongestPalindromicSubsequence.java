import java.util.Arrays;

public class LongestPalindromicSubsequence {

	public static void main(String[] args) {
		String str = "magbdbam";

		int n = str.length();

		int[][] table = longestPalindromicSubsequeceTable(str, n);

		printTable(table);

		String result = findLongest(table, str);

		System.out.println(result);
	}

	private static void printTable(int[][] table) {
		for (int[] row : table) {
			System.out.println(Arrays.toString(row));
		}

	}

	private static String findLongest(int[][] table, String str) {
		int i = 0;
		int j = table[0].length - 1;
		char[] result = new char[table[i][j]];
		int m = i, n = j;
		while(m < n) {
			if (table[m][n] == table[m + 1][n]) {
				m++;
			} else if (table[m][n] == 2 + table[m + 1][n - 1]) {
				result[i] = str.charAt(m);
				result[j - 1] = str.charAt(n);
				m += 1;
				n -= 1;
				i++;
				j--;
			}
		}
		if(m == n) {
			result[i] = str.charAt(m);
		}
		return new String(result);
	}

	private static int[][] longestPalindromicSubsequeceTable(String str, int n) {
		int[][] table = new int[n][n];

		// for single letters
		for (int i = 0; i < n; i++) {
			table[i][i] = 1;
		}

		// for two letters
		for (int i = 0; i < n - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				table[i][i + 1] = 2;
			} else {
				table[i][i + 1] = 1;
			}
		}

		// for 3 or more letters
		for (int k = 3; k <= n; k++) {

			for (int i = 0; i < n - k + 1; i++) {
				int j = i + k - 1;
				if (str.charAt(i) == str.charAt(j)) {
					table[i][j] = 2 + table[i + 1][j - 1];
				} else {
					table[i][j] = Math.max(table[i][j - 1], table[i + 1][j]);
				}
			}
		}

		return table;
	}
}
