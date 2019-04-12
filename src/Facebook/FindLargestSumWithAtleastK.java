package Facebook;

public class FindLargestSumWithAtleastK {

	public static void main(String args[]) {
		int arr[] = { -4, 2, 1, 3 };
		int k = 2;

		System.out.println(findTheLargestSumWithAtleastK(arr, k));
	}

	private static int findTheLargestSumWithAtleastK(int[] arr, int k) {

		int n = arr.length;
		int[] maxSum = new int[n];
		maxSum[0] = arr[0];
		int currSum = arr[0];
		for (int i = 1; i < n; i++) {
			currSum = Math.max(arr[i], currSum + arr[i]);
			maxSum[i] = currSum;
		}

		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum += arr[i];
		}

		int result = sum;

		for (int i = k; i < n; i++) {
			sum = sum + arr[i] - arr[i - k];

			result = Math.max(result, sum);

			result = Math.max(result, sum + maxSum[i - k]);
		}

		return result;
	}
}
