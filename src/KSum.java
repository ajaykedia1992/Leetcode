import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KSum {

	public static void main(String args[]) {
		int nums[] = { 1, 0, -1, 0, -2, 2 };
		int target = 0;
		List<List<Integer>> result = fourSum(nums, target);

		for (List<Integer> r : result) {
			r.stream().map(x -> x).forEach(x -> System.out.print(x + " "));
			System.out.println();
		}
	}

	public static List<List<Integer>> fourSum(int[] A, int target) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(A);

		for (int i = 0; i < A.length; i++) {
			if (i == 0 || A[i] != A[i - 1]) {
				threeSum(list, A, i + 1, A.length - 1, target - A[i], A[i]);
			}
		}
		return list;
	}

	// Three Sum Problem: list.add(Arrays.asList(w, the three numbers))
	private static void threeSum(List<List<Integer>> list, int[] A, int start, int end, int target, int w) {
		for (int j = start; j < end; j++) {
			if (j == start || A[j] != A[j - 1]) {
				twoSum(list, A, j + 1, A.length - 1, target - A[j], w, A[j]);
			}
		}
	}

	// Two Sum Problem: list.add(Arrays.asList(w, x, the two numbers))
	private static void twoSum(List<List<Integer>> list, int[] A, int start, int end, int target, int w, int x) {
		while (start < end) {
			int y = A[start];
			int z = A[end];

			if (y + z == target) {
				list.add(Arrays.asList(w, x, y, z));
				while (start < end && A[start] == A[start + 1])
					start++;
				while (start < end && A[end] == A[end - 1])
					end--;
				start++;
				end--;
			} else if (y + z < target) {
				start++;
			} else {
				end--;
			}
		}
	}
}
