public class RemoveDuplicatesFromSortedArray {

	public static void main(String args[]) {
		int arr[] = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		int result = removeDuplicates(arr);
		System.out.println(result);

		for (int i = 0; i < result; i++) {
			System.out.print(arr[i] + " ");
		}

	}

	public static void swap(int[] nums, int first, int second) {
		int temp = nums[first];
		nums[first] = nums[second];
		nums[second] = temp;
	}

	public static int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[i] == nums[j]) {
				continue;
			}
			swap(nums, i + 1, j);
			i += 1;
		}
		return i + 1;
	}
}
