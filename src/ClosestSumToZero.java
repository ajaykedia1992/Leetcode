import java.util.Arrays;

public class ClosestSumToZero {

	public static void main(String args[]) {
		int[] arr = { 1, 60, -10, 70, -80, 85 };
		int sum = 0;
		int n = arr.length;
		findClosestToZero(arr, n);
	}

	private static void findClosestToZero(int[] arr, int n) {
		if (arr == null || arr.length == 0) {
			return;
		}

		if (arr.length < 2) {
			throw new IllegalArgumentException();
		}
		Arrays.sort(arr);
		int min_l = -1, min_r = -1, l = 0, r = n - 1;

		int closestSum = Integer.MAX_VALUE;
		while (l < r) {
			int sum = Math.abs(arr[l] + arr[r]);
			if (Math.abs(sum) < Math.abs(closestSum)) {
				closestSum = sum;
				min_l = l;
				min_r = r;
			}

			if (sum < 0) {
				l++;
			} else {
				r--;
			}

		}

		System.out.println("output is (" + arr[min_l] + "," + arr[min_r] + ")");
	}
}
