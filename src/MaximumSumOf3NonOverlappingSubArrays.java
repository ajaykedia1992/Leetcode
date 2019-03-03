/*
 * 
 * https://github.com/YaokaiYang-assaultmaster/LeetCode/blob/master/LeetcodeAlgorithmQuestions/689.%20Maximum%20Sum%20of%203%20Non-Overlapping%20Subarrays.md
 */

import java.util.Arrays;

public class MaximumSumOf3NonOverlappingSubArrays {

	public static void main(String argsp[]) {
		int nums[] = { 1, 2, 1, 2, 6, 7, 5, 1 };
		int k = 2;
		int[] ret = new MaximumSumOf3NonOverlappingSubArrays().maxSumOfThreeSubarrays(nums, k);
		System.out.println(Arrays.toString(ret));
	}

	public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
		int n = nums.length;
		int[] sum = new int[n + 1];
		int[] left = new int[n];
		int[] right = new int[n];
		int[] ret = new int[3];

		// First get the prefix sum of nums.
		// Prefix sum enables us to get the sum of k consecutive element in O(1) time
		for (int i = 0; i < n; i++) {
			sum[i + 1] = sum[i] + nums[i];
		}

		System.out.println(Arrays.toString(sum));

		// DP for the left intetval max sum
		for (int i = k, tot = sum[k] - sum[0]; i < n; i++) {
			if (sum[i + 1] - sum[i - k + 1] > tot) {
				tot = sum[i + 1] - sum[i - k + 1];
				left[i] = i - k + 1;
			} else {
				left[i] = left[i - 1];
			}
		}

		System.out.println(Arrays.toString(left));
		// DP for the right interval max sum
		right[n - k] = n - k;
		for (int i = n - 1 - k, tot = sum[n] - sum[n - k]; i >= 0; i--) {
			if (sum[i + k] - sum[i] >= tot) {
				tot = sum[i + k] - sum[i];
				right[i] = i;
			} else {
				right[i] = right[i + 1];
			}
		}

		System.out.println(Arrays.toString(right));
		// Find the max sum by iterating through the middle interval index based on
		// above 2 cache.
		int maxSum = 0;
		for (int i = k; i <= n - 2 * k; i++) {
			int l = left[i - 1], r = right[i + k];
			int tot = sum[l + k] - sum[l] + sum[r + k] - sum[r] + sum[i + k] - sum[i];
			if (tot > maxSum) {
				ret[0] = l;
				ret[1] = i;
				ret[2] = r;
				maxSum = tot;
			}
		}

		return ret;
	}
}
