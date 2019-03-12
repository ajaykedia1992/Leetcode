import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {

	public static void main(String args[]) {
		String[] words = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> res = groupAnagram(words);
		if (res != null) {
			for (List<String> l : res) {
				System.out.println(l);
			}
		}
	}

	private static List<List<String>> groupAnagram(String[] words) {
		if (words == null || words.length == 0) {
			return null;
		}

		int[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101,
				103 };

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<List<String>> result = new ArrayList<>();

		for (String s : words) {
			int key = 1;
			for (int i = 0; i < s.length(); i++) {
				key *= prime[s.charAt(i) - 'a'];
			}

			List<String> t;
			if (map.containsKey(key)) {
				t = result.get(map.get(key));
			} else {
				t = new ArrayList<>();
				result.add(t);
				map.put(key, result.size() - 1);
			}
			t.add(s);
		}

		return result;
	}
}
