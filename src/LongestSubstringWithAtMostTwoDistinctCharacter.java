/*
 * Longest SubString With At Most Two Distinct Character
 */
public class LongestSubstringWithAtMostTwoDistinctCharacter {

	public static void main(String args[]) {
		String str = "eceba";

		System.out.println(findLongestSubstringWithAtMostTwoDistinctCharacter(str));
	}

	private static int findLongestSubstringWithAtMostTwoDistinctCharacter(String str) {

		int[] bank = new int[256];
		int count = 0;
		int maximum = 0;
		int left = 0;
		int right = 0;

		while (right < str.length()) {
			if (bank[str.charAt(right++)]++ == 0) {
				count++;
			}

			while (count > 2) {
				if (bank[str.charAt(left++)]-- == 1) {
					count--;
				}
			}
			maximum = Math.max(maximum, right - left);
		}

		return maximum;
	}
}
