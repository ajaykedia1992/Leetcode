
/*
 * https://leetcode.com/problems/contains-duplicate-ii/
 */

public class ContainsDuplicate {

	public static void main(String args[]) {
		int nums[] = { 1, 2, 3, 1 };
		int  k = 3;
		System.out.println(new ContainsDuplicate().containsNearbyDuplicate(nums, k));
	}

	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if (nums == null || k == 0) {
			return false;
		}

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j <= i + k; j++) {
				if (j < nums.length) {
					if (nums[i] == nums[j]) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
