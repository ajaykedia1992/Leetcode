import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfSquarefulArrays {

	public static void main(String args[]) {

		int[] A = { 1, 17, 8 };
		System.out.println(new NumberOfSquarefulArrays().numSquarefulPerms(A));
	}

	Map<Integer, Integer> count;
	Map<Integer, List<Integer>> graph;

	public int numSquarefulPerms(int[] A) {
		if (A == null) {
			return -1;
		}
		int N = A.length;

		count = new HashMap<>();
		graph = new HashMap<>();

		for (int i = 0; i < N; i++) {
			count.put(A[i], count.getOrDefault(A[i], 0) + 1);
		}

		for (int x : count.keySet()) {
			graph.put(x, new ArrayList<>());
		}

		for (int x : count.keySet()) {
			for (int y : count.keySet()) {
				int r = (int) (Math.sqrt(x + y) + 0.5);
				if (r * r == x + y) {
					graph.get(x).add(y);
				}
			}
		}

		int ans = 0;
		for (int key : count.keySet()) {
			ans += dfs(key, N - 1);
		}
		return ans;
	}

	private int dfs(int key, int N) {
		int ans = 1;
		count.put(key, count.get(key) - 1);
		if (N != 0) {
			ans = 0;
			for (int x : graph.get(key)) {
				if (count.get(x) != 0) {
					ans += dfs(x, N - 1);
				}
			}
		}
		count.put(key, count.get(key) + 1);
		return ans;
	}

}
