
public class AnagramPalindrome {
	
	static final int NO_OF_CHARS = 256;

	public static boolean AnagramPalindrome(String word) {
		int[] count = new int[NO_OF_CHARS];
		for (int i = 0; i < word.length(); i++)
			count[word.charAt(i)]++;
		int odd = 0;
		for (int i = 0; i < NO_OF_CHARS; i++) {
			if ((count[i] & 1) != 0)
				odd++;

			if (odd > 1)
				return false;
		}
		return true;
	}
	
	public static void main(String args[]) {
		String word = "outco";
		System.out.println(AnagramPalindrome(word));
	}
}
