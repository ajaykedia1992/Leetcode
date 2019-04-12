package Facebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutationOfString {

	public static void main(String args[]) {
		String a = "abc";
		List<String> result = permutation(a);
		for (String s : result) {
			System.out.println(s);
		}
	}

	private static List<String> permutation(String s) {
		if (s == null || s.length() == 0) {
			return Collections.emptyList();
		}

		List<String> result = new ArrayList<>();

		permutationUtil( "",  s,result);

		return result;
	}

	private static void permutationUtil(String prefix, String suffix, List<String> result) {

		if (suffix.length() == 0) {
			result.add(prefix);
			return;
		}

		for (int i = 0; i < suffix.length(); i++) {
			permutationUtil(prefix + suffix.charAt(i) , suffix.substring(0, i) + suffix.substring(i + 1), result);
		}

	}

}
