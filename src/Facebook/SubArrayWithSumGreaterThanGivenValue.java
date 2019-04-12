package Facebook;

public class SubArrayWithSumGreaterThanGivenValue {

	public static void main(String args[]) {
		int[] a = { 1, 11, 100, 1, 0, 200, 3, 2, 1, 250 };
		int sum = 280;
		System.out.println(findSubArraySumGreaterThanGivenValue(a, sum));
	}

	private static int findSubArraySumGreaterThanGivenValue(int[] arr, int sum) {
		int n = arr.length;
		int start = 0;
		int end = 0;
		int minLength = n + 1;

		int currSum = 0;
		while (end < n) {
			while (currSum <= sum && end < n) {
				if (currSum < 0 && sum > 0) {
					currSum = 0;
					start = end;
				}
				currSum += arr[end++];
			}

			while (currSum > sum && start < n) {

				if (end - start < minLength) {
					minLength = end - start;
				}

				currSum -= arr[start++];
			}
		}

		return minLength;
	}

}
