import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

	public static void main(String args[]) {
		int arr[] = { 100, 4, 200, 1, 3, 2 };
		System.out.println(new LongestConsecutiveSequence().longestConsecutive(arr));
	}

	private int longestConsecutive(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		Set<Integer> set = new HashSet<Integer>();

		for (int n : nums) {
			set.add(n);
		}
		
		int currentItem = 0, longestItemCount = 0, count = 0;

		for (int i : set) {
			if (!set.contains(i - 1)) {
				currentItem = i;
				count = 1;

				while (set.contains(currentItem + 1)) {
					currentItem += 1;
					count++;
				}

				longestItemCount = Math.max(longestItemCount, count);
			}
		}
		return longestItemCount;
	}
}
