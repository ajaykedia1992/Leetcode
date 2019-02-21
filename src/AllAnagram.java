import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllAnagram {

	public static void main(String args[]) {
		String s = "abacbabc";
		String p = "abc";
		AllAnagram a = new AllAnagram();
		List<Integer> list = a.findAnagrams(s, p);
		if (list.size() == 0) {
			System.out.println(list);
		} else {
			for (Integer i : list) {
				System.out.println(i);
			}
		}
	}

	public Map<Character, Integer> fillMap(String p) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < p.length(); i++) {
			char c = p.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}

		return map;
	}

	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<Integer>();
		if (s.length() != 0 || p.length() != 0 || p.length()<=s.length()) {
			Map<Character, Integer> temp = fillMap(p);

			for (int i = 0; i < s.length() - p.length() + 1; i++) {
				for (int j = i; j < i + p.length(); j++) {
					char c = s.charAt(j);
					if (temp.containsKey(c)) {
						temp.put(c, temp.get(c) - 1);
						if (temp.get(c) == 0) {
							temp.remove(c);
						}
						if (temp.size() == 0) {
							temp = fillMap(p);
							result.add(i);
						}
					} else {
						temp = fillMap(p);
						break;
					}
				}
			}
		}
		return result;
	}
}
