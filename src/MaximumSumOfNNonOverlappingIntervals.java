import java.util.Arrays;

/*
 * https://github.com/YaokaiYang-assaultmaster/LeetCode/blob/master/GeneralizedMethod/Maximum%20Sum%20of%20n%20Non-Overlapping%20Subarrays.md
 */
public class MaximumSumOfNNonOverlappingIntervals {

	public static void main(String args[]) {
		int nums[] = { 7, 13, 20, 19, 19, 2, 10, 1, 1, 19 };//{ 1, 2, 1, 2, 6, 7, 5, 1 };
		int k =  3 ;//2;
		int[] ret = new MaximumSumOfNNonOverlappingIntervals().maxSumOfNSubarrays(nums, k, 3);
		System.out.println(Arrays.toString(ret));
	}

	public int[] maxSumOfNSubarrays(int[] nums, int k, int n) {
		
		/**
		 * @param nums - input array of numbers
		 * @param k - length of each interval
		 * @param n - number of intervals
		 * @return start index of each interval that has the maximum sum
		 */
		int[][] dp = new int[n + 1][nums.length + 1];
		int[][] index = new int[n + 1][nums.length + 1];
		int tot = 0;
		// prefix sum
		int[] sum = new int[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			sum[i + 1] = nums[i] + sum[i];
		}

		for (int i = 1; i <= n; i++) {
			for (int j = k - 1; j < nums.length; j++) {
				int tmpMax = sum[j + 1] - sum[j - k + 1] + dp[i - 1][j - k + 1];
				if (tmpMax > dp[i][j]) {
					dp[i][j + 1] = tmpMax;
					index[i][j + 1] = j - k + 1;
				} else {
					dp[i][j + 1] = dp[i][j];
					index[i][j + 1] = index[i][j];
				}
			}
		}

		int[] ret = new int[n];
		int prev = nums.length;
		for (int i = n; i > 0; i--) {
			ret[i - 1] = index[i][prev];
			prev = ret[i - 1];
		}

		return ret;
	}

}
