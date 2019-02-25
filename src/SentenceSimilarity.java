import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * Given twi sentences words1, words2 (each represented an array of strings), and a list of similar word pairs,
 * determine if two sentences are similar.
 * https://leetcode.com/problems/sentence-similarity/
 */

public class SentenceSimilarity {

	public static void main(String args[]) {
		String[] words1 = { "great", "acting", "skills" };
		String[] words2 = { "fine", "drama", "talent" };
		String[][] pairs = { { "great", "fine" }, { "drama", "acting" }, { "skills", "talent" } };
		System.out.println(areSentencesSimilar(words1, words2, pairs));
	}

	public static boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
		if ((words1 == null && words2 == null) || (words1.length == 0 && words2.length == 0)) {
			return true;
		}
		if ((words1 == null || words2 == null) || (words1.length == 0 || words2.length == 0)) {
			return false;
		}

		if (words1.length != words2.length) {
			return false;
		}

		// words1 and words2 have the similar length

		if (pairs == null || pairs.length == 0) {
			for (int i = 0; i < words1.length; i++) {
				if (!words1[i].equals(words2[i])) {
					return false;
				}
			}
			return true;
		}

		// words1 and words2 are equal length and pair also contains similarity pairs

		Map<String, ArrayList<String>> pairMap = new HashMap<String, ArrayList<String>>();
		for (int i = 0; i < pairs.length; i++) {
			if (pairMap.containsKey(pairs[i][0])) {
				ArrayList<String> a = pairMap.get(pairs[i][0]);
				a.add(pairs[i][1]);
				pairMap.put(pairs[i][0], a);
			} else {
				ArrayList<String> a = new ArrayList<String>();
				a.add(pairs[i][1]);
				pairMap.put(pairs[i][0], a);
			}

			if (pairMap.containsKey(pairs[i][1])) {
				ArrayList<String> a = pairMap.get(pairs[i][1]);
				a.add(pairs[i][0]);
				pairMap.put(pairs[i][1], a);
			} else {
				ArrayList<String> a = new ArrayList<String>();
				a.add(pairs[i][0]);
				pairMap.put(pairs[i][1], a);
			}
		}

		for (int i = 0; i < words1.length; i++) {
			if (words1[i].equals(words2[i])) {
				continue;
			} else if (pairMap.containsKey(words1[i])) {
				if (pairMap.get(words1[i]).contains(words2[i])) {
					continue;
				} else {
					return false;
				}
			} else if (pairMap.containsKey(words2[i])) {
				if (pairMap.get(words2[i]).contains(words1[i])) {
					continue;
				} else {
					return false;
				}
			}

			else {
				return false;
			}
		}
		return true;
	}
}
