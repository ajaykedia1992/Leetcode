package Facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationOfArray {

	public static void main(String args[]) {
		int[] arr = { 1, 2, 3 };
		List<int[]> result = findPermutation(arr);
		for (int[] r : result) {
			System.out.println(Arrays.toString(r));
		}

	}

	private static List<int[]> findPermutation(int[] arr) {

		List<int[]> result = new ArrayList<>();
		permutation(arr, 0, result);

		return result;
	}

	private static void permutation(int[] arr, int start, List<int[]> result) {

		if (start == arr.length) {
			result.add(arr.clone());
			return;
		}

		for (int i = start; i < arr.length; i++) {
			swap(arr, start, i);
			permutation(arr, start + 1, result);
			swap(arr, start, i);
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
