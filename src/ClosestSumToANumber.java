import java.util.Arrays;

public class ClosestSumToANumber {

	public static void main(String args[]) {
		int[] arr = { 1, 60, -10, 70, -80, 85 }; // {10, 22, 28, 29, 30, 40}; //{ 1, 60, -10, 70, -80, 85 };
		int sum = 8;
		int n = arr.length;
		findClosestToNumber(arr, sum, n);
	}

	private static void findClosestToNumber(int[] arr, int x, int n) {
		if (arr == null || arr.length == 0) {
			return;
		}
		if (arr.length < 2) {
			throw new IllegalArgumentException();
		}
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		int minL = -1, minR = -1, diff = Integer.MAX_VALUE, l = 0, r = n - 1;
		while (l < r) {
			int sum = arr[l] + arr[r];
			if (Math.abs(sum - x) < diff) {
				diff = Math.abs(sum - x);
				minL = l;
				minR = r;
			}

			if (sum < x) {
				l++;
			} else {
				r--;
			}
		}

		System.out.println("output is (" + arr[minL] + "," + arr[minR] + ")");
	}

}
