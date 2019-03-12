/*
 * https://youtu.be/9odu9ImG9oY
 * 
 * https://leetcode.com/problems/minimum-window-substring/discuss/26808/Here-is-a-10-line-template-that-can-solve-most-'substring'-problems
 */

public class MinimumWindowSubstring {

	public static void main(String args[]) {
		String str = "ABC";
		String t = "AC";

		System.out.println(findMinimumWindowSubString(str, t));
	}

	private static String findMinimumWindowSubString(String str, String t) {
		int[] bank = new int[256];
		int minimum = Integer.MAX_VALUE;
		int count = 0;
		int left = 0;
		int right = 0;
		String result = "";

		for (int i = 0; i < t.length(); i++) {
			bank[t.charAt(i)]++;
		}

		while (right < str.length()) {

			if (bank[str.charAt(right++)]-- > 0) {
				count++;
			}

			while (count == t.length()) {
				if (minimum > (right - left)) {
					minimum = right - left;
					result = str.substring(left, right);
				}

				if (++bank[str.charAt(left++)] > 0) {
					count--;
				}
			}
		}

		return result;
	}
}
