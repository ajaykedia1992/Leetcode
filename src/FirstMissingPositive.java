public class FirstMissingPositive {

	public static void main(String args[]) {

		int[] nums = { 5, 4, 1, 3, 2, 7, 50, 70, 80 };
		System.out.println(firstMissingPositive(nums));
	}

	public static int firstMissingPositive(int[] nums) {
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			if (nums[i] <= 0 || nums[i] > len) {
				nums[i] = len + 1;
			}
		}

		for (int i = 0; i < len; i++) {
			int n = Math.abs(nums[i]);
			if (n <= len && nums[n - 1] > 0) {
				nums[n - 1] *= -1;
			}
		}

		int first = len + 1;
		for (int i = 0; i < len; i++) {
			if (nums[i] > 0) {
				first = i + 1;
				break;
			}
		}
		return first;
	}
}
