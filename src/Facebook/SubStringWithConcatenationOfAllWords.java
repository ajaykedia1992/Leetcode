package Facebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubStringWithConcatenationOfAllWords {

	public static void main(String args[]) {
		String s = "barfoothefoobarman";
		String[] words = { "foo", "bar" };
		SubStringWithConcatenationOfAllWords sub = new SubStringWithConcatenationOfAllWords();
		System.out.println(sub.findSubstring(s, words));
	}

	public List<Integer> findSubstring(String s, String[] words) {

		if (s == null || s.length() == 0 || words == null || words.length == 0) {
			return Collections.emptyList();
		}

		int len = words.length * words[0].length();

		Map<String, Integer> map = new HashMap<String, Integer>();
		Map<String, Integer> treeMap = null;

		List<Integer> result = new ArrayList<>();
		
		for (String w : words) {
			map.put(w, map.getOrDefault(w, 0) + 1);
		}

		loop : for (int i = 0; i < s.length() - len + 1; i++) {
			treeMap = new HashMap<String, Integer>();
			for (int j = 0; j < len; j += words[0].length()) {
				String sub = s.substring(i + j, i + j + words[0].length());
				
				if (map.containsKey(sub)) {
					treeMap.put(sub, treeMap.getOrDefault(sub, 0) + 1);
				}
				else {
					continue loop;
				}
			}
			
			if(map.equals(treeMap)) {
				result.add(i);
			}
		}
		return result;
	}

}
