import java.util.Arrays;

public class MaximumSumOf3NonOverlappingSubArray {

	public static void main(String args[]) {
		int nums[] = { 7, 13, 20, 19, 19, 2, 10, 1, 1, 19 };
		int k = 3;
		int[] result = findMaximumSumOf3NonOverlappingSubArray(nums, k);
		System.out.println(Arrays.toString(result));
	}

	private static int[] findMaximumSumOf3NonOverlappingSubArray(int[] nums, int k) {
		int ans[] = { -1, -1, -1 };
		if (nums == null || nums.length == 0) {
			return ans;
		}
		int sum = 0;
		int len = nums.length - k + 1;
		int[] windowSum = new int[len];
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (i >= k) {
				sum = sum - nums[i - k];
			}
			if (i >= k - 1) {
				windowSum[i - k + 1] = sum;
			}
		}

		int left[] = new int[len];
		int best = 0;
		for (int i = 0; i < len; i++) {
			if (windowSum[i] > windowSum[best]) {
				best = i;
			}
			left[i] = best;
		}

		int right[] = new int[len];
		best = len - 1;
		for (int i = len - 1; i >= 0; i--) {
			if (windowSum[i] > windowSum[best]) {
				best = i;
			}
			right[i] = best;
		}

		System.out.println(Arrays.toString(windowSum));
		System.out.println(Arrays.toString(left));
		System.out.println(Arrays.toString(right));

		for (int i = k; i < len - k; i++) {
			if (ans[0] == -1 || windowSum[left[i - k]] + windowSum[i] + windowSum[right[i + k]] > windowSum[ans[0]]
					+ windowSum[ans[1]] + windowSum[ans[2]]) {
				ans[0] = left[i - k];
				ans[1] = i;
				ans[2] = right[i + k];
			}
		}

		return ans;
	}
}
