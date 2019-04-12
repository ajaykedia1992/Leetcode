package Facebook;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacter {

	public static void main(String args[]) {
		String s = "abcabcdb";
		System.out.println(findLongestSubstringWithoutRepeatingCharacter(s));
		System.out.println(findLongestSubstringWithoutRepeatingCharacter1(s));
	}

	private static int findLongestSubstringWithoutRepeatingCharacter(String s) {

		if (s == null || s.length() == 0) {
			return -1;
		}

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		int maxSubstringLength = 0;

		for (int i = 0, j = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				j = Math.max(j, map.get(s.charAt(i)) + 1);
			}
			map.put(s.charAt(i), i);
			maxSubstringLength = Math.max(maxSubstringLength, i - j + 1);
		}

		return maxSubstringLength;
	}

	private static int findLongestSubstringWithoutRepeatingCharacter1(String s) {

		int left = 0;
		int right = 0;
		int maxLength = Integer.MIN_VALUE;
		int[] bank = new int[256];
		int n = s.length();
		int count = 0;
		while (right < n) {
			if (bank[s.charAt(right++)]++ > 0) {
				count++;
			}

			while (count > 0) {
				if (bank[s.charAt(left++)]-- > 1) {
					count--;
				}
			}
			maxLength = Math.max(maxLength, right - left);
		}
		return maxLength;
	}
}
