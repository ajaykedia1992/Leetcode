/*
 * https://leetcode.com/problems/split-array-largest-sum/
 */


public class SplitArrayLargestSum {

	public static void main(String args[]) {
		int nums[] = { 7,2,5,10,8};
		int m = 2;
		System.out.println(splitArray(nums, m));
	}

	private static int splitArray(int[] nums, int m) {

		int max = 0;
		long sum = 0;
		for (int num : nums) {
			max = Math.max(max, num);
			sum += num;
		}

		if (m == 1)
			return (int) sum;

		long l = max;
		long r = sum;
		while (l <= r) {
			long mid = (l + r) / 2;
			if (valid(nums, mid, m)) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}

		}

		return (int)l;
	}

	private static boolean valid(int[] nums, long mid, int m) {
		int total = 0;
		int count = 1;
		for (int num : nums) {
			total += num;
			if (total > mid) {
				total = num;
				count++;
				if (count > m) {
					return false;
				}
			}
		}
		return true;
	}
}
