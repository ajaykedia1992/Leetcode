package Facebook;

public class LongestSubstringWithAtleastKRepeatingCharacter {

	public static void main(String args[]) {
		String s = "abcd";
		int k = 2;

		LongestSubstringWithAtleastKRepeatingCharacter l = new LongestSubstringWithAtleastKRepeatingCharacter();
		System.out.println(l.findLongestSubstring(s, k));
	}

	private int findLongestSubstring(String s, int k) {

		if (s == null || s.length() == 0) {
			return 0;
		}

		int start = 0;
		int end = 0;
		int[] arr = new int[26];
		int n = s.length();

		for (char c : s.toCharArray()) {
			arr[c - 'a']++;
		}
		while (end < n) {
			char ch = s.charAt(end);
			if (arr[ch - 'a'] < k) {

				if (start == end) {
					start++;
				} else {
					return Math.max(findLongestSubstring(s.substring(start, end), k),
							findLongestSubstring(s.substring(end + 1), k));
				}

			}
			end++;
		}

		return end - start;
	}
}
