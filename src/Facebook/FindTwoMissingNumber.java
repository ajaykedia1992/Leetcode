package Facebook;

import java.util.Arrays;

public class FindTwoMissingNumber {

	public static void main(String args[]) {
		int[] arr = { 4, 2, 3, 6 };
		System.out.println(Arrays.toString(findTwoMissingNumber(arr)));
	}

	private static int[] findTwoMissingNumber(int[] arr) {

		if (arr == null || arr.length == 0) {
			return new int[] { 1, 2 };
		}

		int n = arr.length + 2;

		long total = n * (n + 1) / 2;

		long arrSum = 0;

		for (int i : arr) {
			arrSum += i;
		}

		long twoMissingVariableSum = total - arrSum;

		int pivot = (int) (twoMissingVariableSum / 2);

		int leftTotalSum = 0, rightTotalSum = 0, leftArraySum = 0, rightArraySum = 0;

		for (int i = 1; i <= pivot; i++) {
			leftTotalSum ^= i;
		}

		for (int i = pivot + 1; i <= n; i++) {
			rightTotalSum ^= i;
		}

		for (int i : arr) {
			if (i <= pivot) {
				leftArraySum ^= i;
			} else {
				rightArraySum ^= i;
			}
		}

		return new int[] { leftTotalSum ^ leftArraySum, rightTotalSum ^ rightArraySum };
	}
}
