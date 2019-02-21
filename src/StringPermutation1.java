import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class StringPermutation1 {

	public static void main(String args[]) {
		String str = "ABABC";
		getAllPermutation(str);
	}

	private static void getAllPermutation(String str) {

		if (str == null) {
			throw new IllegalArgumentException();
		}
		if (str.length() == 0)
			System.out.println("");

		char[] characters = str.toCharArray(); // A, B, C
		Map<Character, Integer> map = new TreeMap<Character, Integer>();

		for (int i = 0; i < characters.length; i++) {
			if (map.containsKey(characters[i])) {
				map.put(characters[i], map.get(characters[i]) + 1);
			} else {
				map.put(characters[i], 1);
			}
		}

		char[] uniqueCharacters = new char[map.size()];
		int[] count = new int[map.size()];
		int i = 0;
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			uniqueCharacters[i] = entry.getKey();
			count[i] = entry.getValue();
			i++;
		}
		char[] result = new char[str.length()];

		System.out.println(Arrays.toString(uniqueCharacters));
		System.out.println(Arrays.toString(count));

		getPermutationUtil(uniqueCharacters, count, result, 0);

	}

	private static void getPermutationUtil(char[] uniqueCharacters, int[] count, char[] result, int level) {
		if (level == result.length) {
			System.out.println(String.copyValueOf(result));
			return;
		}

		for (int i = 0; i < uniqueCharacters.length; i++) {
			if (count[i] == 0) {
				continue;
			}
			result[level] = uniqueCharacters[i];
			count[i]--;
			getPermutationUtil(uniqueCharacters, count, result, level + 1);
			count[i]++;
		}

	}

}
