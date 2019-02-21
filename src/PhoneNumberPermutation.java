import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumberPermutation {

	public static void main(String args[]) {
		String str = "34";
		List<String> output = new PhoneNumberPermutation().letterCombinations(str);

		for (String s : output) {
			System.out.println(s);
		}
	}

	Map<String, String> map = new HashMap<String, String>() {
		{

			put("2", "abc");
			put("3", "def");
			put("4", "ghi");
			put("5", "jkl");
			put("6", "mno");
			put("7", "pqrs");
			put("8", "tuv");
			put("9", "wxyz");
		}
	};

	List<String> result = new ArrayList<String>();

	public void generateLetterCombination(String combined, String digits) {

		if (digits.length() == 0) {
			result.add(combined);
		}

		else {
			String number = map.get(digits.substring(0, 1));

			for (int i = 0; i < number.length(); i++) {
				String letter = number.substring(i, i + 1);
				generateLetterCombination(combined + letter, digits.substring(1));
			}
		}

	}

	public List<String> letterCombinations(String digits) {

		if (digits == null || digits.length() == 0) {
			return result;
		}

		String str = "";

		generateLetterCombination(str, digits);

		return result;

	}
}
