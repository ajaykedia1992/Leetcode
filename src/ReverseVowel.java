
public class ReverseVowel {

	public static void main(String args[]) {
		String word = "San Francisco";
		System.out.println(reverseVowel(word));
	}

	static boolean checkVowel(char c) {
		if (c == 'A' || c == 'a' || c == 'E' || c == 'e' || c == 'I' || c == 'i' || c == 'O' || c == 'o' || c == 'U'
				|| c == 'u') {
			return true;
		}
		return false;
	}

	private static String reverseVowel(String word) {
		if (word == null || word.length() == 0) {
			return null;
		}
		char[] str1 = word.toCharArray();
		for (int i = 0, j = str1.length - 1; i < j;) {
			if (!checkVowel(str1[i])) {
				i++;
				continue;
			}
			if (!checkVowel(str1[j])) {
				j--;
				continue;
			}
			char temp = str1[i];
			str1[i] = str1[j];
			str1[j] = temp;
			i++;
			j--;
		}
		String str = String.copyValueOf(str1);
		return str;
	}
}
