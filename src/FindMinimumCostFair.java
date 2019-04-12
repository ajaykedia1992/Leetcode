import java.util.HashMap;
import java.util.Map;

public class FindMinimumCostFair {

	public static void main(String args[]) {
		int D[] = { 4, 8, 2, 7, 5 };
		int R[] = { 7, 1, 1, 8, 3 };

		// output 10 => (8,2)

		System.out.println(findMinimumCost(D, R));
		System.out.println(findMinimumCost1(D, R));
	}

	private static int findMinimumCost1(int[] d, int[] r) {
		int minimumCost = Integer.MAX_VALUE;

		Map<Integer, int[]> dict = new HashMap<>();

		createMap(dict, r);

		for (int i = 0; i < d.length; i++) {
			if (minimumCost > d[i] + dict.get(i)[1]) {
				minimumCost = d[i] + dict.get(i)[1];
			}
		}

		return minimumCost;
	}

	private static void createMap(Map<Integer, int[]> dict, int[] R) {
		int min = Integer.MAX_VALUE;
		for (int i = R.length - 1; i >= 0; i--) {
			if (min > R[i]) {
				min = R[i];
			}
			int v[] = { R[i], min };
			dict.put(i, v);
		}
	}

	private static int findMinimumCost(int[] d, int[] r) {
		int minCost = Integer.MAX_VALUE;
		for (int i = 0; i < d.length; i++) {
			for (int j = i; j < r.length; j++) {
				if (minCost > d[i] + r[j]) {
					minCost = d[i] + r[j];
				}
			}
		}
		return minCost;
	}

}
