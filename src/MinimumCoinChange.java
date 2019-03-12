import java.util.Arrays;

/*
 * Given an input x, write a function to determine the minimum number of coins required to make that exact amount of change.
 * 
 */
public class MinimumCoinChange {

	public static void main(String args[]) {
		int[] coins = { 1, 3, 4 };
		int x = 6;
		int result = minimumCoinChange(x, coins);
		System.out.println(result);
	}

	private static int minimumCoinChange(int x, int[] coins) {

		if (coins == null || coins.length == 0) {
			return 0;
		}

		int[] cache = new int[x];

		Arrays.fill(cache, -1);

		return minimumCoinChange(x, coins, cache);
	}

	private static int minimumCoinChange(int x, int[] coins, int[] cache) { // here cache is for optimization

		if (x == 0) {
			return 0;
		}

		int min = x;

		for (int i = 0; i < coins.length; i++) {
			if (x - coins[i] >= 0) { // if the difference is less than 0, then skip
				int c;
				if (cache[x - coins[i]] >= 0) {
					c = cache[x - coins[i]];
				} else {
					c = minimumCoinChange(x - coins[i], coins, cache);
					cache[x - coins[i]] = c;
				}
				if (min > c + 1) {
					min = c + 1;
				}
			}
		}

		return min;
	}
}
