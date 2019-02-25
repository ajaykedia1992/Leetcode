/*
 * Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array 
 * that is constructed by these N Numbers successfully if one of following is true for the ith 
 * position (1<=i<=N) in this array:
 * 1. The number at the ith position is divisible by i.
 * i is divisible by the number at the ith position. Now given N, how many beautiful arrangements 
 * can you construct?
 */

public class ArrayBeautifulArrangementOfNumber {

	static int count = 0;

	public static void main(String args[]) {
		int N = 3;
		boolean[] visited = new boolean[N + 1];
		findTotalNumberOfBeautifulArrangement(N, N, visited);
		System.out.println(count);
	}

	private static void findTotalNumberOfBeautifulArrangement(int N, int K, boolean[] visited) {

		if (K == 0) {
			count++;
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (visited[i] || (i % K != 0 && K % i != 0)) {
				continue;
			}

			visited[i] = true;
			findTotalNumberOfBeautifulArrangement(N, K - 1, visited);
			visited[i] = false;
		}

	}
}
