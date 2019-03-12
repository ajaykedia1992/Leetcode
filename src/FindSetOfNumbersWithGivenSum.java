import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindSetOfNumbersWithGivenSum {

	public static void main(String args[]) {
		int arr[] = { 2, 4, 6, 10 };
		int sum = 16; // output = 2
		Arrays.sort(arr);
		System.out.println(findSetOfNumbersWithGivenSum(arr, sum, arr.length - 1));
	}

	private static int findSetOfNumbersWithGivenSum(int[] arr, int sum, int index) {
		Map<String, Integer> map = new HashMap<>();
		return findSetOfNumbersWithGivenSumWithMemorization(arr, sum, index, map);
	}

	private static int findSetOfNumbersWithGivenSumWithMemorization(int[] arr, int sum, int index,
			Map<String, Integer> map) {
		if (arr == null || arr.length == 0) {
			return 0;
		}

		String key = "" + sum + ":" + index;
		if (map.containsKey(key)) {
			return map.get(key);
		}
		int value;

		if (sum == 0) {
			return 1;
		}

		if (index < 0 || index >= arr.length) {
			return 0;
		}

		if (sum < 0) {
			return 0;

		} else if (sum < arr[index]) {
			value = findSetOfNumbersWithGivenSum(arr, sum, index - 1);
		} else {
			value = findSetOfNumbersWithGivenSum(arr, sum - arr[index], index - 1)
					+ findSetOfNumbersWithGivenSum(arr, sum, index - 1);
		}
		map.put(key, value);

		return value;
	}

	private static int findSetOfNumbersWithGivenSumWithoutMemorization(int[] arr, int sum, int index,
			Map<String, Integer> map) {

		if (arr == null || arr.length == 0) {
			return 0;
		}

		if (sum == 0) {
			return 1;
		}

		if (index < 0 || index >= arr.length) {
			return 0;
		}

		if (sum < 0) {
			return 0;

		} else if (sum < arr[index]) {
			return findSetOfNumbersWithGivenSum(arr, sum, index - 1);
		} else {
			return findSetOfNumbersWithGivenSum(arr, sum - arr[index], index - 1)
					+ findSetOfNumbersWithGivenSum(arr, sum, index - 1);
		}

	}
}
