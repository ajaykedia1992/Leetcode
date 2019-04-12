package Facebook;

import java.util.Arrays;

/*
 * Convert first string into second using minimum edit distance
 */

public class MinimumEditDistance {

	public static void main(String args[]) {
		String first = "abcdef";
		String second = "azced";

		int[][] minimumEditDistance = new int[second.length() + 1][first.length() + 1];

		minimumEditDistance[0][0] = 0;

		int minimumEditsRequired = getMinimumEditDistance(first, second, minimumEditDistance);

		System.out.println(minimumEditsRequired);

		for (int[] m : minimumEditDistance) {
			System.out.println(Arrays.toString(m));
		}

	}

	private static int getMinimumEditDistance(String first, String second, int[][] minimumEditDistance) {

		for (int i = 1; i <= first.length(); i++) {
			minimumEditDistance[0][i] = minimumEditDistance[0][i - 1] + 1;
		}
		for (int i = 1; i <= second.length(); i++) {
			minimumEditDistance[i][0] = minimumEditDistance[i - 1][0] + 1;
		}

		for (int i = 0; i < second.length(); i++) {
			for (int j = 0; j < first.length(); j++) {
				if (second.charAt(i) == first.charAt(j)) {
					minimumEditDistance[i + 1][j + 1] = minimumEditDistance[i][j];
				} else {
					minimumEditDistance[i + 1][j + 1] = Math.min(
							Math.min(minimumEditDistance[i + 1][j], minimumEditDistance[i][j]),
							minimumEditDistance[i][j + 1]) + 1;
				}
			}
		}

		return minimumEditDistance[second.length()][first.length()];
	}
}
