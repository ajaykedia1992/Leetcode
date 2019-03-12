import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {

	public static void main(String args[]) {
		int arr[] = {1};
		FindFirstAndLastPositionOfElementInSortedArray f = new FindFirstAndLastPositionOfElementInSortedArray();
		System.out.println(Arrays.toString(f.searchRange(arr, 1)));
	}

	public int[] searchRange(int[] nums, int target) {

		int low = 0;
		int high = nums.length - 1;
		int ans[] = { -1, -1 };

		while (low <= high) {
			int mid = (low + high) / 2;

			if (nums[mid] == target) {
				int i = mid, j = mid;
				while (i - 1 >= low) {
					if (target == nums[i - 1]) {
						i--;
					} else {
						break;
					}
				}
				while (j + 1 <= high) {
					if (target == nums[j + 1]) {
						j++;
					} else {
						break;
					}
				}

				ans[0] = i;
				ans[1] = j;
				break;
			} else if (target < nums[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}
}
