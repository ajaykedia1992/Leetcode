import java.util.Arrays;

public class MoveZeros {

	public static void main(String args[]) {
		int nums[] = { 0, 1, 0, 3, 12 };
		moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
	}

	public static void moveZeroes(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}

		for (int i = 0, j = 1; j < nums.length;) {
			if (nums[i] == 0 && nums[j] != 0) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				i++;
				j++;
			} else if (nums[i] != 0 && nums[j] != 0) {
				i++;
				j++;
				continue;
			} else if (nums[i] != 0 && nums[j] == 0) {
				i++;
			} else {
				j++;
			}
		}
	}
}
