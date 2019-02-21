import java.util.Arrays;
import java.util.PriorityQueue;

public class SquareSortedArray {

	public static void main(String args[]) {
		int[] arr = { -4, -1, 0, 3, 10 };
		System.out.println(Arrays.toString(sortedSquares(arr)));
	}

	private static int[] sortedSquares(int[] A) {
		if (A == null || A.length == 0) {
			return null;
		}

		int[] result = new int[A.length];

		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

		for (int i = 0; i < A.length; i++) {
			minHeap.add(A[i] * A[i]);
		}
		int k = 0;
		while (!minHeap.isEmpty()) {
			result[k++] = minHeap.poll();
		}
		return result;
	}
}
