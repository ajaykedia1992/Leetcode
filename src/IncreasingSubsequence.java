
public class IncreasingSubsequence {

	public static int findLengthOfLCIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int count = 1;
		int flag = -1;
		for (int i = 0; i < nums.length; i++) {
			int temp = 1;
			for (int j = i; j < nums.length - 1; j++) {
				if (nums[j] < nums[j + 1]) {
					temp++;
				} else {
					flag = j;
					break;

				}

				if (j == nums.length - 2) {
					flag = j + 1;
				}
			}
			if (count < temp) {
				count = temp;

			}
			i = flag;
		}

		return count;
	}

	public static int findLengthOfIncreasingSubsequence(int[] nums) {
		int ans = 0, anchor = 0;
		for (int i = 0; i < nums.length; ++i) {
			if (i > 0 && nums[i - 1] >= nums[i])
				anchor = i;
			ans = Math.max(ans, i - anchor + 1);
		}
		return ans;
	}

	public static void main(String args[]) {
		int[] nums = { 1, 3, 5, 4, 2, 3, 4, 5 };
		System.out.println(findLengthOfIncreasingSubsequence(nums));
	}
}
