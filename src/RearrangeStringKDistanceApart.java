import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeStringKDistanceApart {

	public static void main(String args[]) {
		String str = "aabbbcc";
		int k = 3;
		String result = rearrangeStringKDistanceApart(str, k);
		System.out.println(result);
	}

	private static String rearrangeStringKDistanceApart(String str, int k) {

		if (str == null || str.length() == 0) {
			return "";
		}

		char[] ctr = str.toCharArray();

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < ctr.length; i++) {
			map.put(ctr[i], map.getOrDefault(ctr[i], 0) + 1);
		}

		PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>() {

			@Override
			public int compare(Character C1, Character C2) {

				if (map.get(C2).intValue() != map.get(C1).intValue()) {
					return map.get(C2) - map.get(C1);
				}

				return C1.compareTo(C2);
			}
		});

		for (char i : map.keySet()) {
			queue.offer(i);
		}

		StringBuffer result = new StringBuffer("");
		int len = str.length();
		while (!queue.isEmpty()) {
			int limit = Math.min(k, len);

			// Store the characters after each traversal
			ArrayList<Character> arr = new ArrayList<Character>();

			for (int i = 0; i < limit; i++) {
				if (queue.isEmpty()) {
					return "";
				}
				char c = queue.poll();
				result.append(String.valueOf(c));
				map.put(c, map.get(c) - 1);

				if (map.get(c) > 0) {
					arr.add(c);
				}
				len--;
			}

			for (char c : arr) {
				queue.offer(c);
			}

		}

		return result.toString();
	}
}
