
public class LongestSubStringWithoutRepeatingCharacter {

	public static void main(String args[]) {
		String str = "ABCDEBCDEFGHIJKL";
		System.out.println(findLongestSubStringWithoutRepeatingCharacter(str));
	}

	private static int findLongestSubStringWithoutRepeatingCharacter(String str) {
		int[] bank = new int[256];
		int count = 0;
		int maximum = Integer.MIN_VALUE;
		int left = 0;
		int right = 0;

		while (right < str.length()) {
			if (bank[str.charAt(right++)]++ > 0) {
				count++;
			}

			while (count > 0) {	
				if(bank[str.charAt(left++)] -- > 1) {
					count--;
				}
			}
			maximum = Math.max(maximum, right - left);
		}

		return maximum;
	}
}
