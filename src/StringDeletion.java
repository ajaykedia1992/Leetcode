import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * Given a string and a dictionary HashSet, write a function to determine the minimum number of characters to delete to make a word.
 */

public class StringDeletion {

	public static void main(String args[]) {
		String dictionary[] = { "a", "aa", "aaa", "ac" };
		String query = "abcderg";
		System.out.println(minimumDeletionFromQuery(dictionary, query));
	}

	private static int minimumDeletionFromQuery(String[] dictionary, String query) {

		Set<String> dict = new HashSet<>(Arrays.asList(dictionary));

		int minimumCount = 0;

		if (dict.contains(query)) {
			return minimumCount;
		}

		Set<String> set = new HashSet<>();

		Queue<String> queue = new LinkedList<>();
		queue.add(query);
		set.add(query);

		while (!queue.isEmpty()) {

			String temp = queue.poll();

			for (int i = 0; i < temp.length(); i++) {
				String s = temp.substring(0, i) + temp.substring(i + 1);
				if (!set.contains(s) && s.length() > 0) {
					queue.add(s);
					set.add(s);
				}
			}

		}

		minimumCount = query.length() + 1;
		for (String s : set) {
			if (dict.contains(s)) {
				if (minimumCount > query.length() - s.length()) {
					minimumCount = query.length() - s.length();
				}
			}
		}

		return minimumCount;
	}

}
