import java.util.Arrays;

public class MinSwapIncreasingOrder {

	public static void main(String args[]) {
		int m[] = { 1, 3, 5, 4 };
		int n[] = { 1, 2, 3, 7 };

		int mininumSwap = findMinimumSwap(m, n);
		System.out.println(mininumSwap);
	}

	private static int findMinimumSwap(int[] m, int[] n) {
		if (m.length != n.length) {
			return -1;
		}

		int k = m.length;
		int x[] = new int[k]; // no_swap
		int y[] = new int[k]; // swap
		Arrays.fill(x, 0);
		Arrays.fill(y, 1);

		for (int i = 1; i < k; i++) {
			x[i] = y[i] = k;
			if (m[i] > m[i - 1] && n[i] > n[i - 1]) {
				x[i] = x[i - 1];
				y[i] = y[i - 1] + 1;
			}
			if (m[i] > n[i - 1] && n[i] > m[i - 1]) {
				x[i] = Math.min(x[i], y[i - 1]);
				y[i] = Math.min(y[i], x[i - 1] + 1);
			}

		}

		return Math.min(x[k - 1], y[k - 1]);
	}
}
